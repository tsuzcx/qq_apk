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

public class bfeq
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static String a;
  protected int a;
  protected Handler a;
  protected QQAppInterface a;
  protected FaceDecoder a;
  public GridView a;
  protected List<ajnr> a;
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
  
  public bfeq(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
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
    int i = paramString2.getDimensionPixelSize(2131298043);
    this.jdField_b_of_type_Int = a((Activity)paramWeakReference.get());
    this.jdField_c_of_type_Int = ajpz.a(this.jdField_b_of_type_Int);
    paramGridView.setColumnWidth(this.jdField_b_of_type_Int);
    paramGridView.setVerticalSpacing(i);
    paramGridView.setHorizontalSpacing(i);
    paramGridView.setAdapter(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public int a(Activity paramActivity)
  {
    int i = paramActivity.getResources().getDimensionPixelSize(2131298043);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298046) * 2 - i * 3) / 4;
  }
  
  public ajnr a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (ajnr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Rect a(int paramInt)
  {
    ajnr localajnr = a(paramInt);
    Rect localRect = new Rect();
    if (localajnr != null) {
      ajpz.a(localRect, localajnr.jdField_d_of_type_JavaLangString);
    }
    return localRect;
  }
  
  protected void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 0) && (this.jdField_a_of_type_JavaUtilList.size() < 7))
    {
      ajnr localajnr = new ajnr();
      localajnr.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilList.add(localajnr);
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
  
  public void a(ajnr paramajnr, bfed parambfed)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof bfer)))
      {
        localObject = (bfer)localObject;
        if (((bfer)localObject).jdField_a_of_type_Ajnr.equals(paramajnr))
        {
          if (paramajnr.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((bfer)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((bfer)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(parambfed.jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(bfer parambfer, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = parambfer.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(DisplayUtil.dip2px(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166539));
      ImageView localImageView = parambfer.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(8);
      if (paramInt1 != 4) {
        break label135;
      }
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      parambfer = paramContext;
      if (paramContext == null) {
        parambfer = new FrameLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      parambfer.gravity = 17;
      localImageView.setLayoutParams(parambfer);
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
        parambfer = ajpz.a(paramString);
      } while (parambfer == null);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      parambfer = URLDrawable.getDrawable(parambfer, paramContext);
      paramContext = a(paramInt2);
      parambfer.setTag(bfol.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      parambfer.setDecodeHandler(bfol.y);
      if (this.f) {
        parambfer.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(parambfer);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("viewFactory: FROM_OTHERS, path=" + paramString, new Object[0]));
  }
  
  public void a(List<ajnr> paramList)
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
        localView = LayoutInflater.from((Context)localObject1).inflate(2131559870, null);
      }
      ajnr localajnr = a(paramInt);
      int i;
      label102:
      bfer localbfer2;
      if (localajnr != null)
      {
        i = localajnr.jdField_b_of_type_Int;
        if (i != 4) {
          break label447;
        }
        paramView = (View)localObject2;
        if (localView.getTag() != null) {
          break label614;
        }
        localbfer2 = new bfer(this);
        localbfer2.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362132));
        localbfer2.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131368443));
        if (localObject1 == null) {}
      }
      for (;;)
      {
        try
        {
          localbfer2.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(((Activity)localObject1).getResources().getDrawable(2130843709));
          localbfer2.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)localView.findViewById(2131368367));
          localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (localObject2 == null)
          {
            localObject2 = new AbsListView.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
            localbfer2.jdField_a_of_type_Ajnr = localajnr;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localView.setTag(localbfer2);
            localObject2 = localbfer2;
            if (localObject1 != null)
            {
              localView.setContentDescription(amtj.a(2131700013) + paramInt);
              if (i == 4) {
                localView.setContentDescription(amtj.a(2131700012));
              }
              a((bfer)localObject2, (Context)localObject1, i, paramView, paramInt, localajnr.jdField_d_of_type_Boolean);
            }
            paramView = ((bfer)localObject2).jdField_a_of_type_AndroidWidgetProgressBar;
            if (!localajnr.jdField_a_of_type_Boolean) {
              break label634;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localajnr.jdField_c_of_type_Int);
            paramView.setProgress(100);
            if (!localajnr.jdField_c_of_type_Boolean) {
              break label643;
            }
            if (((bfer)localObject2).jdField_a_of_type_AndroidViewView == null)
            {
              ((bfer)localObject2).jdField_a_of_type_AndroidViewView = ((ViewStub)localView.findViewById(2131380369)).inflate();
              localView.setTag(localObject2);
            }
            ((bfer)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
            if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
              break label664;
            }
            localView.setVisibility(8);
            paramView = localView;
            localObject1 = localView;
            break;
            label447:
            if ((i == 1) && ((localajnr.jdField_b_of_type_JavaLangString == null) || (!new File(localajnr.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = beyx.b(beyx.a(localajnr.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
              break label102;
            }
            if ((i == 2) || ((localajnr.jdField_b_of_type_JavaLangString != null) && (new File(localajnr.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = localajnr.jdField_b_of_type_JavaLangString;
              break label102;
            }
            paramView = (View)localObject2;
            if (i != 3) {
              break label102;
            }
            paramView = beyx.b(beyx.a(localajnr.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
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
        bfer localbfer1 = (bfer)localView.getTag();
        localbfer1.jdField_a_of_type_Ajnr = localajnr;
        continue;
        label634:
        paramView.setVisibility(8);
        continue;
        label643:
        if (localbfer1.jdField_a_of_type_AndroidViewView != null)
        {
          localbfer1.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
 * Qualified Name:     bfeq
 * JD-Core Version:    0.7.0.1
 */