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
import com.tencent.biz.qcircleshadow.local.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amhq
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private amhv jdField_a_of_type_Amhv;
  private amhw jdField_a_of_type_Amhw;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new amht(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public amhq(QQAppInterface paramQQAppInterface, Context paramContext, List<arpq> paramList, amhv paramamhv, amhw paramamhw)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Amhv = paramamhv;
    this.jdField_a_of_type_Amhw = paramamhw;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845306);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845317);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private arpq a(ArrayList<arpq> paramArrayList)
  {
    if (paramArrayList != null) {}
    try
    {
      if (paramArrayList.size() > 0)
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          arpq localarpq = (arpq)localIterator.next();
          if ((localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 1001L)) {
            paramArrayList.remove(localarpq);
          }
        }
      }
      if ((QzoneConfig.isQQCircleShowLebaEntrance()) && (QzoneConfig.isQQCircleShowSwitchButton()))
      {
        paramArrayList = new arpq();
        paramArrayList.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo = new LebaPluginInfo();
        paramArrayList.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId = 1001L;
        if (QzoneConfig.isQQCircleShowLebaBySwitchButton()) {}
        for (int i = 0;; i = 1)
        {
          paramArrayList.jdField_a_of_type_Byte = ((byte)i);
          paramArrayList.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName = anvx.a(2131719158);
          paramArrayList.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL = "https://sola.gtimg.cn/aoi/sola/20201012111557_48i6yoJLfi.png";
          QLog.e("LebaListMgrAdapter", 1, "showQcircleItem");
          return paramArrayList;
        }
      }
      return null;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("LebaListMgrAdapter", 1, "getQcircleItem" + paramArrayList);
    }
    return null;
  }
  
  private void a(RedTouch paramRedTouch, arpq paramarpq, boolean paramBoolean)
  {
    byte b1;
    if (paramBoolean)
    {
      b1 = 0;
      paramarpq.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramarpq.jdField_a_of_type_Byte);
      }
      if ((paramarpq == null) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 1001L)) {
        break label124;
      }
      b(paramBoolean);
    }
    for (;;)
    {
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Amhw != null) {
        this.jdField_a_of_type_Amhw.a(paramarpq);
      }
      return;
      b1 = 1;
      break;
      label124:
      long l = NetConnInfoCenter.getServerTimeMillis();
      ajzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((aoch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.RED_TOUCH_HANDLER)).a(String.valueOf(paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        l = paramarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localbbbq.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.d();
        }
      }
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(paramAppInfo);
  }
  
  private void a(ArrayList<arpq> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((arpq)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((arpq)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((arpq)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((arpq)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((arpq)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((arpq)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Amhv == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_Int = 0;
      localArrayList = new ArrayList();
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof arpq))
        {
          localObject2 = (arpq)localObject2;
          if ((this.jdField_a_of_type_Amhv.a((arpq)localObject2)) && (((arpq)localObject2).jdField_a_of_type_Boolean) && (((arpq)localObject2).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject2);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new anxq());
    Object localObject1 = a(localArrayList);
    if (localObject1 != null) {
      localArrayList.add(0, localObject1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  private void b(boolean paramBoolean)
  {
    String str = "";
    Object localObject;
    HashMap localHashMap;
    if (paramBoolean)
    {
      localObject = "1";
      localHashMap = new HashMap();
      if ((bdvn.a()) || (!paramBoolean)) {
        break label136;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        localHashMap.put("qqcircle_entrance_enable_on_children_mode", str);
        QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", str);
      }
      localHashMap.put("qqcircle_entrance_enable", localObject);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", (String)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("qqcircle", localHashMap);
      localObject = new QCircleSetMultiCircleWnsConfigRequest((HashMap)localObject);
      VSNetworkHelper.getInstance().sendRequest((VSBaseRequest)localObject, new amhu(this, paramBoolean, str));
      return;
      localObject = "0";
      break;
      label136:
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
    }
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(List<arpq> paramList)
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
    arpq localarpq = (arpq)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    label168:
    label206:
    RedTouch localRedTouch;
    label254:
    String str;
    label362:
    label379:
    int i;
    if (paramView == null)
    {
      localObject2 = new amhx();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559130, paramViewGroup, false);
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369979));
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370050));
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370049));
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131364056));
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramView).d(100).a();
      paramView.setTag(localObject2);
      if (!ThemeUtil.isDefaultTheme()) {
        break label744;
      }
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850257);
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
      localRedTouch = (RedTouch)paramView;
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      if (localarpq.jdField_a_of_type_Byte != 0) {
        break label779;
      }
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new amhr(this, localRedTouch, localarpq));
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "getview name: " + localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localarpq.jdField_a_of_type_Byte);
      }
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      ((amhx)localObject2).jdField_a_of_type_Arpq = localarpq;
      if (!this.jdField_a_of_type_Boolean) {
        break label807;
      }
      localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (!this.jdField_a_of_type_Boolean) {
        break label816;
      }
      str = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl;
      if (!this.jdField_a_of_type_Boolean) {
        break label829;
      }
      i = AIOUtils.dp2px(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      label401:
      Object localObject3 = (RelativeLayout.LayoutParams)((amhx)localObject2).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = i;
      ((RelativeLayout.LayoutParams)localObject3).height = i;
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = localObject1;
      if (localarpq != null)
      {
        localObject3 = localObject1;
        if (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)
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
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
      if (localObject3 != null) {
        ThemeUtil.setThemeFilter((Drawable)localObject3, ThemeUtil.curThemeId);
      }
      if (localarpq.jdField_a_of_type_Byte != 1) {
        break label847;
      }
      long l = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
      a((RedTouch)paramView, "100600." + (100000000L + l) + "");
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          bgyd.a(((amhx)localObject2).jdField_a_of_type_AndroidWidgetTextView, false);
          bgyd.a(((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch, false);
          bgyd.a(((amhx)localObject2).jdField_a_of_type_AndroidWidgetImageView, false);
          ((amhx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(((amhx)localObject2).jdField_a_of_type_AndroidWidgetTextView.getText());
        }
        if (Build.VERSION.SDK_INT >= 14) {
          ((amhx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
        }
        ((amhx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new amhs(this, localRedTouch, localarpq));
      }
      localObject2 = paramView;
      break;
      localObject2 = (amhx)paramView.getTag();
      break label168;
      label744:
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850254);
      ((amhx)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
      break label206;
      label779:
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      ((amhx)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label254;
      label807:
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label362;
      label816:
      str = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL;
      break label379;
      label829:
      i = AIOUtils.dp2px(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label401;
      label847:
      ((RedTouch)paramView).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhq
 * JD-Core Version:    0.7.0.1
 */