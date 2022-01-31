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

public class banc
  extends BaseAdapter
  implements baxl
{
  public static String a;
  protected int a;
  protected Handler a;
  protected baxk a;
  protected QQAppInterface a;
  public GridView a;
  protected List<aglg> a;
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
  
  public banc(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
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
    this.jdField_a_of_type_Baxk = new baxk(paramString1, paramQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    paramString2 = paramString1.getResources();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = paramString2.getDimensionPixelSize(2131297874);
    this.jdField_b_of_type_Int = a((Activity)paramWeakReference.get());
    this.jdField_c_of_type_Int = agqs.a(this.jdField_b_of_type_Int);
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
  
  public aglg a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (aglg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Rect a(int paramInt)
  {
    aglg localaglg = a(paramInt);
    Rect localRect = new Rect();
    if (localaglg != null) {
      agqs.a(localRect, localaglg.jdField_d_of_type_JavaLangString);
    }
    return localRect;
  }
  
  protected void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 0) && (this.jdField_a_of_type_JavaUtilList.size() < 7))
    {
      aglg localaglg = new aglg();
      localaglg.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilList.add(localaglg);
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
  
  public void a(aglg paramaglg, bamm parambamm)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof band)))
      {
        localObject = (band)localObject;
        if (((band)localObject).jdField_a_of_type_Aglg.equals(paramaglg))
        {
          if (paramaglg.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((band)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((band)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(parambamm.jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(band paramband, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = paramband.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(bawz.a(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166393));
      ImageView localImageView = paramband.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(8);
      if (paramInt1 != 4) {
        break label135;
      }
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      paramband = paramContext;
      if (paramContext == null) {
        paramband = new FrameLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      paramband.gravity = 17;
      localImageView.setLayoutParams(paramband);
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
        paramband = agqs.a(paramString);
      } while (paramband == null);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = aywk.a;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      paramband = URLDrawable.getDrawable(paramband, paramContext);
      paramContext = a(paramInt2);
      paramband.setTag(bavi.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      paramband.setDecodeHandler(bavi.x);
      if (this.f) {
        paramband.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(paramband);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("viewFactory: FROM_OTHERS, path=" + paramString, new Object[0]));
  }
  
  public void a(List<aglg> paramList)
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
      aglg localaglg;
      do
      {
        return paramView;
        paramViewGroup = LayoutInflater.from(localActivity).inflate(2131559667, null);
        localaglg = a(paramInt);
        paramView = paramViewGroup;
      } while (localaglg == null);
      int i = localaglg.jdField_b_of_type_Int;
      band localband2;
      if (i == 4)
      {
        paramView = (View)localObject;
        if (paramViewGroup.getTag() != null) {
          break label570;
        }
        localband2 = new band(this);
        localband2.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362064));
        localband2.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131367875));
        if (localActivity == null) {}
      }
      for (;;)
      {
        try
        {
          localband2.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localActivity.getResources().getDrawable(2130843070));
          localband2.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)paramViewGroup.findViewById(2131367799));
          localObject = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
          if (localObject == null)
          {
            localObject = new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
            localband2.jdField_a_of_type_Aglg = localaglg;
            paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramViewGroup.setTag(localband2);
            localObject = localband2;
            if (localActivity != null)
            {
              paramViewGroup.setContentDescription(ajyc.a(2131700854) + paramInt);
              if (i == 4) {
                paramViewGroup.setContentDescription(ajyc.a(2131700853));
              }
              a((band)localObject, localActivity, i, paramView, paramInt, localaglg.jdField_d_of_type_Boolean);
            }
            paramView = ((band)localObject).jdField_a_of_type_AndroidWidgetProgressBar;
            if (!localaglg.jdField_a_of_type_Boolean) {
              break label589;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localaglg.jdField_c_of_type_Int);
            paramView.setProgress(100);
            if (!localaglg.jdField_c_of_type_Boolean) {
              break label598;
            }
            if (((band)localObject).jdField_a_of_type_AndroidViewView == null)
            {
              ((band)localObject).jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131378840)).inflate();
              paramViewGroup.setTag(localObject);
            }
            ((band)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
            if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
              break label619;
            }
            paramViewGroup.setVisibility(8);
            return paramViewGroup;
            if ((i == 1) && ((localaglg.jdField_b_of_type_JavaLangString == null) || (!new File(localaglg.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = bahh.b(bahh.a(localaglg.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
              break;
            }
            if ((i == 2) || ((localaglg.jdField_b_of_type_JavaLangString != null) && (new File(localaglg.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = localaglg.jdField_b_of_type_JavaLangString;
              break;
            }
            paramView = (View)localObject;
            if (i != 3) {
              break;
            }
            paramView = bahh.b(bahh.a(localaglg.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
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
        band localband1 = (band)paramViewGroup.getTag();
        localband1.jdField_a_of_type_Aglg = localaglg;
        continue;
        label589:
        paramView.setVisibility(8);
        continue;
        label598:
        if (localband1.jdField_a_of_type_AndroidViewView != null) {
          localband1.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
 * Qualified Name:     banc
 * JD-Core Version:    0.7.0.1
 */