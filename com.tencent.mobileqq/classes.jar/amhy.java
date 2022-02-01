import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amhy
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private awdo jdField_a_of_type_Awdo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet(30);
  private List<arpq> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public amhy(Context paramContext, List<arpq> paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845306);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Awdo != null)
    {
      ajzv localajzv = new ajzv();
      localajzv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localajzv.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidContentContext;
      localajzv.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = paramRedTouch;
      localajzv.jdField_a_of_type_Long = paramLong;
      localajzv.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Awdo.a(localajzv);
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(paramInt1);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_").append(paramInt2);
      return;
    }
    if ((this.jdField_a_of_type_Awdo != null) && (this.jdField_a_of_type_Awdo.a() != null))
    {
      paramLong = (awdr)this.jdField_a_of_type_Awdo.a().get(paramLong);
      if (paramLong == null) {}
    }
    for (paramLong = Integer.valueOf(paramLong.jdField_a_of_type_Int);; paramLong = null)
    {
      paramStringBuilder = paramStringBuilder.append("_");
      if (paramLong == null) {}
      for (paramInt1 = 0;; paramInt1 = paramLong.intValue())
      {
        paramStringBuilder.append(paramInt1);
        return;
      }
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, Map<Long, Integer> paramMap)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(0);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_").append(0);
      return;
    }
    Integer localInteger = null;
    if (paramMap != null) {
      localInteger = (Integer)paramMap.get(paramLong);
    }
    paramLong = paramStringBuilder.append("_");
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      paramLong.append(i);
      return;
    }
  }
  
  public Map<Long, Integer> a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      arpq localarpq = (arpq)localIterator.next();
      if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (a(localarpq))) {
        break label114;
      }
      localHashMap.put(Long.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), Integer.valueOf(i));
      i += 1;
    }
    label114:
    for (;;)
    {
      break;
      return localHashMap;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)))
          {
            if (((Integer)((View)localObject).getTag(-1)).intValue() == 0)
            {
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
              }
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10004L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10004L));
              }
            }
            else
            {
              int j = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (j >= 0)) {
                localObject = (arpq)this.jdField_a_of_type_JavaUtilList.get(j);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof amhz)))
          {
            localObject = (amhz)((View)localObject).getTag();
            if ((localObject != null) && (((amhz)localObject).jdField_a_of_type_Arpq != null) && (((amhz)localObject).jdField_a_of_type_Arpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
            {
              long l = ((amhz)localObject).jdField_a_of_type_Arpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      Map localMap = a();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong.longValue() != 10004L) || (paramBoolean))
        {
          localStringBuilder.append(localLong);
          a(localLong, localStringBuilder, localMap);
          a(localLong, localStringBuilder, paramInt1, paramInt2);
          if (localIterator.hasNext()) {
            localStringBuilder.append(";");
          }
        }
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", "", localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(awdo paramawdo)
  {
    this.jdField_a_of_type_Awdo = paramawdo;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List<arpq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(arpq paramarpq)
  {
    return !TextUtils.isEmpty(paramarpq.jdField_a_of_type_JavaLangString);
  }
  
  public void b()
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (arpq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((arpq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    if (getItem(paramInt) == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    arpq localarpq = (arpq)getItem(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject3;
    if (i == 0) {
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.b, null);
        localObject2 = new amhz(this);
        ((amhz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131369979));
        ((amhz)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370050));
        ((amhz)localObject2).jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)((View)localObject1).findViewById(2131370049));
        ((amhz)localObject2).jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blfw.c);
        ((amhz)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131362986));
        localObject1 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject1).d(36).a();
        ((View)localObject1).setTag(localObject2);
        if ((localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
          ((amhz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        }
        ((amhz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
        localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          break label673;
        }
        if (TextUtils.isEmpty(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL)) {
          break label658;
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = AIOUtils.dp2px(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject3 = URLDrawable.getDrawable(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject3).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((amhz)localObject2).jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject3);
        ((amhz)localObject2).jdField_a_of_type_Arpq = localarpq;
        if ((localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
        {
          a((RedTouch)localObject1, localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
          }
        }
        if ((AppSetting.c) && (localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (!TextUtils.isEmpty(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName))) {
          bgyd.a((View)localObject1, localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, Button.class.getName());
        }
      }
    }
    label658:
    label673:
    while (i != 1) {
      for (;;)
      {
        if (localObject1 != null)
        {
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject1).setTag(-1, Integer.valueOf(paramInt));
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper();
        if ((localarpq != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 770L) && (localObject2 != null)) {
          ((anxl)localObject2).g();
        }
        if (paramInt == 0)
        {
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
          }
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10004L))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10004L));
          }
        }
        break;
        localObject2 = (amhz)paramView.getTag();
        localObject1 = paramView;
        continue;
        ((amhz)localObject2).jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        continue;
        ((amhz)localObject2).jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    if (paramView == null) {}
    for (Object localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.c, null);; localObject2 = paramView)
    {
      boolean bool = bdfk.b();
      ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      localObject3 = ((View)localObject2).findViewById(2131365157);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject1 = ((View)localObject3).getLayoutParams();
      if (bool) {
        i = 0;
      }
      ((ViewGroup.LayoutParams)localObject1).height = i;
      localObject1 = localObject2;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((arpq)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhy
 * JD-Core Version:    0.7.0.1
 */