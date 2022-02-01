import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amdc
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private amdg jdField_a_of_type_Amdg;
  private amdh jdField_a_of_type_Amdh;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new amdf(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public amdc(QQAppInterface paramQQAppInterface, Context paramContext, List<arcs> paramList, amdg paramamdg, amdh paramamdh)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Amdg = paramamdg;
    this.jdField_a_of_type_Amdh = paramamdh;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845327);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845338);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, arcs paramarcs, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 0;; b1 = 1)
    {
      paramarcs.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramarcs.jdField_a_of_type_Byte);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      ajvi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((antt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        baif localbaif = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        l = paramarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localbaif.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.d();
        }
      }
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Amdh != null) {
        this.jdField_a_of_type_Amdh.a(paramarcs);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void a(ArrayList<arcs> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((arcs)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((arcs)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((arcs)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((arcs)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((arcs)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((arcs)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Amdg == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_Int = 0;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof arcs))
        {
          localObject = (arcs)localObject;
          if ((this.jdField_a_of_type_Amdg.a((arcs)localObject)) && (((arcs)localObject).jdField_a_of_type_Boolean) && (((arcs)localObject).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new anoz());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  public void a() {}
  
  public void a(List<arcs> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    arcs localarcs = (arcs)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((localarcs == null) || (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    label173:
    label206:
    RedTouch localRedTouch;
    label254:
    String str;
    label362:
    label379:
    int i;
    if (paramView == null)
    {
      localObject2 = new amdi();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559094, paramViewGroup, false);
      ((amdi)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369724));
      ((amdi)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369788));
      ((amdi)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369787));
      ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131363933));
      if (ThemeUtil.isDefaultTheme())
      {
        ((amdi)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850222);
        ((amdi)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166993));
        paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localObject2);
        localRedTouch = (RedTouch)paramView;
        ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localarcs.jdField_a_of_type_Byte != 0) {
          break label777;
        }
        ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new amdd(this, localRedTouch, localarcs));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localarcs.jdField_a_of_type_Byte);
        }
        ((amdi)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        ((amdi)localObject2).jdField_a_of_type_Arcs = localarcs;
        if (!this.jdField_a_of_type_Boolean) {
          break label805;
        }
        localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (!this.jdField_a_of_type_Boolean) {
          break label814;
        }
        str = localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl;
        if (!this.jdField_a_of_type_Boolean) {
          break label827;
        }
        i = afur.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        label401:
        Object localObject3 = (RelativeLayout.LayoutParams)((amdi)localObject2).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).width = i;
        ((RelativeLayout.LayoutParams)localObject3).height = i;
        ((amdi)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = localObject1;
        if (localarcs != null)
        {
          localObject3 = localObject1;
          if (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)
          {
            localObject3 = localObject1;
            if (!TextUtils.isEmpty(str))
            {
              localObject3 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
              localObject3 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject3);
              ((URLDrawable)localObject3).setTargetDensity(this.jdField_a_of_type_Int);
              if (((URLDrawable)localObject3).getStatus() == 2) {
                ((URLDrawable)localObject3).restartDownload();
              }
              ((Drawable)localObject3).setColorFilter(-1, PorterDuff.Mode.DST_IN);
            }
          }
        }
        ((amdi)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        if (localObject3 != null) {
          ThemeUtil.setThemeFilter((Drawable)localObject3, ThemeUtil.curThemeId);
        }
        if (localarcs.jdField_a_of_type_Byte != 1) {
          break label845;
        }
        long l = localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          bgfz.a(((amdi)localObject2).jdField_a_of_type_AndroidWidgetTextView, false);
          bgfz.a(((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch, false);
          bgfz.a(((amdi)localObject2).jdField_a_of_type_AndroidWidgetImageView, false);
          ((amdi)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(((amdi)localObject2).jdField_a_of_type_AndroidWidgetTextView.getText());
        }
        if (Build.VERSION.SDK_INT >= 14) {
          ((amdi)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
        }
        ((amdi)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new amde(this, localRedTouch, localarcs));
      }
      localObject2 = paramView;
      break;
      ((amdi)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850219);
      ((amdi)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986));
      break label173;
      localObject2 = (amdi)paramView.getTag();
      break label206;
      label777:
      ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      ((amdi)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label254;
      label805:
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label362;
      label814:
      str = localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL;
      break label379;
      label827:
      i = afur.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label401;
      label845:
      ((RedTouch)paramView).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdc
 * JD-Core Version:    0.7.0.1
 */