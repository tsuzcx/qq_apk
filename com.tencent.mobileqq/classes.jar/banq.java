import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter.1;
import com.tencent.mobileqq.troop.widget.BorderURLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

public class banq
  extends BaseAdapter
  implements baxz
{
  public static String a;
  protected int a;
  protected Handler a;
  protected baxy a;
  protected QQAppInterface a;
  public GridView a;
  protected List<agle> a;
  protected WeakReference<Activity> a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  public boolean c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvatarGridAdapter";
  }
  
  public banq(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Boolean = paramBoolean1;
    a(paramBoolean2);
    if ((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
      }
      throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    paramString1 = (Activity)paramWeakReference.get();
    this.jdField_a_of_type_Baxy = new baxy(paramString1, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    paramString2 = paramString1.getResources();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = paramString2.getDimensionPixelSize(2131297874);
    this.jdField_b_of_type_Int = a((Activity)paramWeakReference.get());
    this.jdField_c_of_type_Int = agqq.a(this.jdField_b_of_type_Int);
    paramGridView.setColumnWidth(this.jdField_b_of_type_Int);
    paramGridView.setVerticalSpacing(i);
    paramGridView.setHorizontalSpacing(i);
    paramGridView.setAdapter(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public int a(Activity paramActivity)
  {
    int i = paramActivity.getResources().getDimensionPixelSize(2131297874);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131297877) * 2 - i * 3) / 4;
  }
  
  public agle a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (agle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Rect a(int paramInt)
  {
    agle localagle = a(paramInt);
    Rect localRect = new Rect();
    if (localagle != null) {
      agqq.a(localRect, localagle.jdField_d_of_type_JavaLangString);
    }
    return localRect;
  }
  
  protected void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 0) && (this.jdField_a_of_type_JavaUtilList.size() < 7))
    {
      agle localagle = new agle();
      localagle.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilList.add(localagle);
    }
  }
  
  public void a(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt != this.jdField_a_of_type_ComTencentWidgetGridView.c())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_a_of_type_ComTencentWidgetGridView.e() * paramInt + (paramInt - 1) * this.jdField_a_of_type_ComTencentWidgetGridView.b() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingRight());
      localLayoutParams.height = -2;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label123;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label141;
      }
    }
    label141:
    for (Activity localActivity = null;; localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if ((localActivity == null) || (Thread.currentThread() == localActivity.getMainLooper().getThread())) {
        break label155;
      }
      localActivity.runOnUiThread(new AvatarGridAdapter.1(this, paramInt, localLayoutParams));
      return;
      label123:
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break;
      }
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      break;
    }
    label155:
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(paramInt);
    this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
  }
  
  public void a(agle paramagle, bana parambana)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof banr)))
      {
        localObject = (banr)localObject;
        if (((banr)localObject).jdField_a_of_type_Agle.equals(paramagle))
        {
          if (paramagle.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((banr)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((banr)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(parambana.jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(banr parambanr, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = parambanr.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(baxn.a(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166393));
      ImageView localImageView = parambanr.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(8);
      if (paramInt1 != 4) {
        break label135;
      }
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      parambanr = paramContext;
      if (paramContext == null) {
        parambanr = new FrameLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      parambanr.gravity = 17;
      localImageView.setLayoutParams(parambanr);
      localImageView.setVisibility(0);
    }
    label135:
    do
    {
      do
      {
        do
        {
          return;
          localBorderURLImageView.setBorderWidth(0);
          break;
        } while (paramString == null);
        parambanr = agqq.a(paramString);
      } while (parambanr == null);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = aywm.a;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      parambanr = URLDrawable.getDrawable(parambanr, paramContext);
      paramContext = a(paramInt2);
      parambanr.setTag(bavw.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      parambanr.setDecodeHandler(bavw.x);
      if (this.f) {
        parambanr.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(parambanr);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("viewFactory: FROM_OTHERS, path=" + paramString, new Object[0]));
  }
  
  public void a(List<agle> paramList)
  {
    if (this.e) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("updateDataSet %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    int j = 4;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (i < 4) {
        j = i;
      }
      a(j);
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        if (localActivity != null) {}
      }
      agle localagle;
      do
      {
        return paramView;
        paramViewGroup = LayoutInflater.from(localActivity).inflate(2131559667, null);
        localagle = a(paramInt);
        paramView = paramViewGroup;
      } while (localagle == null);
      int i = localagle.jdField_b_of_type_Int;
      banr localbanr2;
      if (i == 4)
      {
        paramView = (View)localObject;
        if (paramViewGroup.getTag() != null) {
          break label570;
        }
        localbanr2 = new banr(this);
        localbanr2.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362063));
        localbanr2.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131367875));
        if (localActivity == null) {}
      }
      for (;;)
      {
        try
        {
          localbanr2.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localActivity.getResources().getDrawable(2130843071));
          localbanr2.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)paramViewGroup.findViewById(2131367799));
          localObject = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
          if (localObject == null)
          {
            localObject = new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
            localbanr2.jdField_a_of_type_Agle = localagle;
            paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramViewGroup.setTag(localbanr2);
            localObject = localbanr2;
            if (localActivity != null)
            {
              paramViewGroup.setContentDescription(ajya.a(2131700865) + paramInt);
              if (i == 4) {
                paramViewGroup.setContentDescription(ajya.a(2131700864));
              }
              a((banr)localObject, localActivity, i, paramView, paramInt, localagle.jdField_d_of_type_Boolean);
            }
            paramView = ((banr)localObject).jdField_a_of_type_AndroidWidgetProgressBar;
            if (!localagle.jdField_a_of_type_Boolean) {
              break label589;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localagle.jdField_c_of_type_Int);
            paramView.setProgress(100);
            if (!localagle.jdField_c_of_type_Boolean) {
              break label598;
            }
            if (((banr)localObject).jdField_a_of_type_AndroidViewView == null)
            {
              ((banr)localObject).jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131378845)).inflate();
              paramViewGroup.setTag(localObject);
            }
            ((banr)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
            if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
              break label619;
            }
            paramViewGroup.setVisibility(8);
            return paramViewGroup;
            if ((i == 1) && ((localagle.jdField_b_of_type_JavaLangString == null) || (!new File(localagle.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = bahv.b(bahv.a(localagle.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
              break;
            }
            if ((i == 2) || ((localagle.jdField_b_of_type_JavaLangString != null) && (new File(localagle.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = localagle.jdField_b_of_type_JavaLangString;
              break;
            }
            paramView = (View)localObject;
            if (i != 3) {
              break;
            }
            paramView = bahv.b(bahv.a(localagle.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError, new Object[0]);
          continue;
          localOutOfMemoryError.height = this.jdField_c_of_type_Int;
          localOutOfMemoryError.width = this.jdField_b_of_type_Int;
          continue;
        }
        label570:
        banr localbanr1 = (banr)paramViewGroup.getTag();
        localbanr1.jdField_a_of_type_Agle = localagle;
        continue;
        label589:
        paramView.setVisibility(8);
        continue;
        label598:
        if (localbanr1.jdField_a_of_type_AndroidViewView != null) {
          localbanr1.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      label619:
      paramViewGroup.setVisibility(0);
      return paramViewGroup;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     banq
 * JD-Core Version:    0.7.0.1
 */