import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class apov
  extends BaseAdapter
{
  public static final String a;
  protected float a;
  public int a;
  protected Context a;
  protected appt a;
  public apsm a;
  public QQAppInterface a;
  protected EmotionPanelListView a;
  protected List<apsj> a;
  protected Map<Integer, ArrayList<View>> a;
  public int b;
  protected List<apsj> b;
  protected int c;
  protected List<apsj> c;
  public int d;
  protected int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseAdapter.class.getSimpleName();
  }
  
  public apov(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, appt paramappt)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Appt = paramappt;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.e = paramContext.getResources().getColor(2131166424);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public abstract View a(apow paramapow, int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public RelativeLayout a()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getEmotionLayout");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.d / this.jdField_a_of_type_Int, (int)(72.0F * this.jdField_a_of_type_Float)));
    try
    {
      Object localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject1).setId(2131365671);
        ((TextView)localObject1).setTextColor(this.e);
        ((TextView)localObject1).setTextSize(11.0F);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
        ((TextView)localObject1).setGravity(17);
        localRelativeLayout.addView((View)localObject1, localLayoutParams);
      }
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject1).setId(2131365666);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(2, 2131365671);
      localLayoutParams.addRule(14);
      ((URLImageView)localObject1).setVisibility(8);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      ((URLImageView)localObject1).setAdjustViewBounds(false);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setId(2131365672);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131365666);
      localLayoutParams.addRule(8, 2131365666);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (AppSetting.c) {
        localRelativeLayout.setFocusable(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getEmotionlayout cost = " + (System.currentTimeMillis() - l));
      }
      return localRelativeLayout;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public abstract apow a();
  
  public EmoticonPackage a()
  {
    return null;
  }
  
  public EmotionPanelListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destory");
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        int j = ((Integer)((Map.Entry)localObject).getKey()).intValue();
        localObject = (ArrayList)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((ArrayList)localObject).size())
          {
            View localView = (View)((ArrayList)localObject).get(i);
            if (localView.getParent() != null) {
              ((ViewGroup)localView.getParent()).removeView(localView);
            }
            localView.setTag(null);
            if ((localView instanceof EmoticonPanelLinearLayout)) {
              ((EmoticonPanelLinearLayout)localView).setCallBack(null);
            }
            Integer localInteger = (Integer)localView.getTag(2131365710);
            if (apsr.jdField_a_of_type_Int == localInteger.intValue()) {
              apsr.a().a(j, localView);
            }
            i += 1;
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = null;
    if (this.jdField_a_of_type_Appt != null) {
      this.jdField_a_of_type_Appt = null;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "recycleView viewType = " + paramInt);
      }
      paramView.setTag(2131365710, Integer.valueOf(this.d));
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
    } while (localArrayList.contains(paramView));
    localArrayList.add(paramView);
  }
  
  public void a(View paramView, apsj paramapsj)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateBigEmotionContentViewData");
    }
    if ((paramView != null) && (paramapsj != null))
    {
      paramView.setVisibility(0);
      localObject1 = null;
      if ((paramapsj instanceof appw)) {
        localObject1 = (appw)paramapsj;
      }
      if (localObject1 != null) {
        break label61;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "emotionInfo = null");
    }
    label61:
    Object localObject2;
    do
    {
      return;
      paramView.setTag(localObject1);
      paramapsj = (URLImageView)paramView.findViewById(2131365666);
      long l = System.currentTimeMillis();
      localObject2 = ((appw)localObject1).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getDrawable cost = " + (System.currentTimeMillis() - l));
      }
      paramapsj.setImageDrawable((Drawable)localObject2);
      paramapsj.setVisibility(0);
    } while (!(localObject1 instanceof aptm));
    paramapsj = (aptm)localObject1;
    Object localObject1 = (TextView)paramView.findViewById(2131365671);
    if (paramapsj.a != null)
    {
      localObject2 = paramapsj.a.name;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label286;
      }
      ((TextView)localObject1).setVisibility(0);
      if (((String)localObject2).length() > 5) {
        ((TextView)localObject1).setText(((String)localObject2).substring(0, 4) + "...");
      }
    }
    else
    {
      paramView = (ImageView)paramView.findViewById(2131365672);
      if (!paramapsj.b()) {
        break label306;
      }
      if (!paramapsj.c()) {
        break label296;
      }
      paramView.setImageResource(2130838173);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break;
      label286:
      ((TextView)localObject1).setVisibility(8);
      break;
      label296:
      paramView.setImageResource(2130849757);
    }
    label306:
    paramView.setVisibility(4);
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = paramEmotionPanelListView;
  }
  
  public void a(List<apsj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void b() {}
  
  public void c() {}
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = k / this.jdField_a_of_type_Int;
      int i = j;
      if (k % this.jdField_a_of_type_Int > 0) {
        i = j + 1;
      }
      return i;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "get count len = 0");
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (apow localapow = a();; localapow = (apow)paramView.getTag()) {
      return a(localapow, paramInt, paramView, paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apov
 * JD-Core Version:    0.7.0.1
 */