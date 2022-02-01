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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter.1;
import com.tencent.mobileqq.troop.widget.BorderURLImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

public class bgmw
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static String a;
  protected int a;
  protected Handler a;
  protected QQAppInterface a;
  protected FaceDecoder a;
  public GridView a;
  protected List<akjf> a;
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
  
  public bgmw(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramString1, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    paramString2 = paramString1.getResources();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = paramString2.getDimensionPixelSize(2131298046);
    this.jdField_b_of_type_Int = a((Activity)paramWeakReference.get());
    this.jdField_c_of_type_Int = akln.a(this.jdField_b_of_type_Int);
    paramGridView.setColumnWidth(this.jdField_b_of_type_Int);
    paramGridView.setVerticalSpacing(i);
    paramGridView.setHorizontalSpacing(i);
    paramGridView.setAdapter(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public int a(Activity paramActivity)
  {
    int i = paramActivity.getResources().getDimensionPixelSize(2131298046);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298049) * 2 - i * 3) / 4;
  }
  
  public akjf a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (akjf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Rect a(int paramInt)
  {
    akjf localakjf = a(paramInt);
    Rect localRect = new Rect();
    if (localakjf != null) {
      akln.a(localRect, localakjf.jdField_d_of_type_JavaLangString);
    }
    return localRect;
  }
  
  protected void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 0) && (this.jdField_a_of_type_JavaUtilList.size() < 7))
    {
      akjf localakjf = new akjf();
      localakjf.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilList.add(localakjf);
    }
  }
  
  public void a(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt != this.jdField_a_of_type_ComTencentWidgetGridView.getNumColumns())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_a_of_type_ComTencentWidgetGridView.getRequestedColumnWidth() * paramInt + (paramInt - 1) * this.jdField_a_of_type_ComTencentWidgetGridView.getVerticalSpacing() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingRight());
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
  
  public void a(akjf paramakjf, bgmj parambgmj)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof bgmx)))
      {
        localObject = (bgmx)localObject;
        if (((bgmx)localObject).jdField_a_of_type_Akjf.equals(paramakjf))
        {
          if (paramakjf.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((bgmx)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((bgmx)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(parambgmj.jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(bgmx parambgmx, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = parambgmx.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(DisplayUtil.dip2px(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166553));
      ImageView localImageView = parambgmx.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(8);
      if (paramInt1 != 4) {
        break label135;
      }
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      parambgmx = paramContext;
      if (paramContext == null) {
        parambgmx = new FrameLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      parambgmx.gravity = 17;
      localImageView.setLayoutParams(parambgmx);
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
        parambgmx = akln.a(paramString);
      } while (parambgmx == null);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      parambgmx = URLDrawable.getDrawable(parambgmx, paramContext);
      paramContext = a(paramInt2);
      parambgmx.setTag(bgxc.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      parambgmx.setDecodeHandler(bgxc.y);
      if (this.f) {
        parambgmx.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(parambgmx);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("viewFactory: FROM_OTHERS, path=" + paramString, new Object[0]));
  }
  
  public void a(List<akjf> paramList)
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
    Object localObject2 = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (Object localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localObject1 = null)
    {
      View localView = paramView;
      if (paramView == null)
      {
        if (localObject1 == null)
        {
          localView = paramView;
          localObject1 = paramView;
          paramView = localView;
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
        }
        localView = LayoutInflater.from((Context)localObject1).inflate(2131559914, null);
      }
      akjf localakjf = a(paramInt);
      int i;
      label102:
      bgmx localbgmx2;
      if (localakjf != null)
      {
        i = localakjf.jdField_b_of_type_Int;
        if (i != 4) {
          break label447;
        }
        paramView = (View)localObject2;
        if (localView.getTag() != null) {
          break label614;
        }
        localbgmx2 = new bgmx(this);
        localbgmx2.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362136));
        localbgmx2.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131368600));
        if (localObject1 == null) {}
      }
      for (;;)
      {
        try
        {
          localbgmx2.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(((Activity)localObject1).getResources().getDrawable(2130843747));
          localbgmx2.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)localView.findViewById(2131368524));
          localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (localObject2 == null)
          {
            localObject2 = new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
            localbgmx2.jdField_a_of_type_Akjf = localakjf;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localView.setTag(localbgmx2);
            localObject2 = localbgmx2;
            if (localObject1 != null)
            {
              localView.setContentDescription(anvx.a(2131700364) + paramInt);
              if (i == 4) {
                localView.setContentDescription(anvx.a(2131700363));
              }
              a((bgmx)localObject2, (Context)localObject1, i, paramView, paramInt, localakjf.jdField_d_of_type_Boolean);
            }
            paramView = ((bgmx)localObject2).jdField_a_of_type_AndroidWidgetProgressBar;
            if (!localakjf.jdField_a_of_type_Boolean) {
              break label634;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localakjf.jdField_c_of_type_Int);
            paramView.setProgress(100);
            if (!localakjf.jdField_c_of_type_Boolean) {
              break label643;
            }
            if (((bgmx)localObject2).jdField_a_of_type_AndroidViewView == null)
            {
              ((bgmx)localObject2).jdField_a_of_type_AndroidViewView = ((ViewStub)localView.findViewById(2131380705)).inflate();
              localView.setTag(localObject2);
            }
            ((bgmx)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
            if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
              break label664;
            }
            localView.setVisibility(8);
            paramView = localView;
            localObject1 = localView;
            break;
            label447:
            if ((i == 1) && ((localakjf.jdField_b_of_type_JavaLangString == null) || (!new File(localakjf.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = bghb.b(bghb.a(localakjf.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
              break label102;
            }
            if ((i == 2) || ((localakjf.jdField_b_of_type_JavaLangString != null) && (new File(localakjf.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = localakjf.jdField_b_of_type_JavaLangString;
              break label102;
            }
            paramView = (View)localObject2;
            if (i != 3) {
              break label102;
            }
            paramView = bghb.b(bghb.a(localakjf.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
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
        label614:
        bgmx localbgmx1 = (bgmx)localView.getTag();
        localbgmx1.jdField_a_of_type_Akjf = localakjf;
        continue;
        label634:
        paramView.setVisibility(8);
        continue;
        label643:
        if (localbgmx1.jdField_a_of_type_AndroidViewView != null)
        {
          localbgmx1.jdField_a_of_type_AndroidViewView.setVisibility(8);
          continue;
          label664:
          localView.setVisibility(0);
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgmw
 * JD-Core Version:    0.7.0.1
 */