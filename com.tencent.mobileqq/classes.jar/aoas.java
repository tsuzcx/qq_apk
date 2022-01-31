import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.av.AVNetEngine;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class aoas
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private int b;
  private int c;
  
  public aoas(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    paramInt1 = DisplayUtil.a(getContext(), 6.0F);
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int - paramInt1 * ((this.b - 1) * 2)) / this.b);
    a();
  }
  
  private URLDrawable a(InfomationFacePackage.Item paramItem)
  {
    Object localObject1 = (QIMInformationPasterManager)QIMManager.a().c(12);
    Object localObject2 = QIMInformationPasterManager.b();
    localObject1 = paramItem.jdField_a_of_type_JavaLangString + "_static.png";
    localObject2 = new File((String)localObject2);
    if (((File)localObject2).exists()) {
      if (!((File)localObject2).isDirectory()) {
        ((File)localObject2).delete();
      }
    }
    for (;;)
    {
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "static file name:" + ((File)localObject1).getAbsolutePath());
      }
      paramItem = new URL(paramItem.jdField_c_of_type_JavaLangString);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).Recycle();
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.a();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.a;
      return URLDrawable.getDrawable(paramItem, (URLDrawable.URLDrawableOptions)localObject1);
      ((File)localObject2).mkdirs();
    }
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(17);
    int j = DisplayUtil.a(getContext(), 12.0F);
    int k = (int)((this.jdField_c_of_type_Int - j * 2) * this.jdField_a_of_type_Float);
    int i = 0;
    if (i < this.b)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2130970756, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
      if (i == 0) {
        localLayoutParams.setMargins(0, j, j / 2, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        ((ImageView)localView.findViewById(2131371828)).setPadding(k, k, k, k);
        addView(localView);
        i += 1;
        break;
        if (this.b - 1 == i) {
          localLayoutParams.setMargins(j / 2, j, 0, 0);
        } else {
          localLayoutParams.setMargins(j / 2, j, j / 2, 0);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= paramInt) {
        break;
      }
      j = paramInt;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while ((j < this.b) && (j < getChildCount()))
    {
      getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
  
  private void a(InfomationFacePackage.Item paramItem, URLImageView paramURLImageView, QIMCommonLoadingView paramQIMCommonLoadingView, ProgressBar paramProgressBar, aoaw paramaoaw)
  {
    Object localObject1 = (QIMInformationPasterManager)QIMManager.a().c(12);
    Object localObject2 = QIMInformationPasterManager.b();
    localObject1 = paramItem.jdField_a_of_type_JavaLangString + "_dynamic.png";
    localObject2 = new File((String)localObject2);
    String str;
    if (((File)localObject2).exists())
    {
      if (!((File)localObject2).isDirectory()) {
        ((File)localObject2).delete();
      }
      localObject2 = new File((File)localObject2, (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "apng file name:" + ((File)localObject2).getAbsolutePath());
      }
      str = ((File)localObject2).getAbsolutePath();
      bool2 = false;
      bool1 = false;
      if (!((File)localObject2).exists()) {}
    }
    for (;;)
    {
      try
      {
        bool1 = ApngDrawable.isApngFile((File)localObject2);
        if (bool1) {}
        try
        {
          localObject1 = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), ((File)localObject2).getAbsolutePath(), "-Dynamic-", URLDrawableHelper.a, new int[] { 13 }, "-Dynamic-", null);
          if (localObject1 != null)
          {
            if (((URLDrawable)localObject1).getStatus() != 1) {
              ((URLDrawable)localObject1).restartDownload();
            }
            if (((URLDrawable)localObject1).getStatus() == 1) {
              paramaoaw.onLoadSuccessed(paramURLImageView, (URLDrawable)localObject1);
            }
            paramURLImageView.setImageDrawable((Drawable)localObject1);
          }
          if (!bool1)
          {
            paramURLImageView = new java.lang.ref.WeakReference(paramURLImageView);
            paramQIMCommonLoadingView = new java.lang.ref.WeakReference(paramQIMCommonLoadingView);
            paramProgressBar = new mqq.util.WeakReference(paramProgressBar);
            localObject1 = paramItem.b;
            HttpNetReq localHttpNetReq = new HttpNetReq();
            ((ProgressBar)paramProgressBar.get()).setVisibility(8);
            ((ImageView)paramURLImageView.get()).setVisibility(8);
            ((QIMCommonLoadingView)paramQIMCommonLoadingView.get()).setProgress(0L);
            ((QIMCommonLoadingView)paramQIMCommonLoadingView.get()).setVisibility(0);
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aoat(this, (File)localObject2, paramQIMCommonLoadingView, paramURLImageView, str, paramaoaw);
            localHttpNetReq.jdField_a_of_type_JavaLangString = ((String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("InformationFaceAdapter", 2, "apng url:" + (String)localObject1);
            }
            localHttpNetReq.jdField_a_of_type_Int = 0;
            localHttpNetReq.jdField_c_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
            localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
            localHttpNetReq.a(paramItem);
            AVNetEngine.a().a(localHttpNetReq);
          }
          return;
        }
        catch (IOException localIOException1) {}
        ((File)localObject2).mkdirs();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("InformationFaceAdapter", 2, "apng invalid file:" + ((File)localObject2).getAbsolutePath());
        }
        ((File)localObject2).delete();
        continue;
      }
      catch (IOException localIOException2)
      {
        bool1 = bool2;
        continue;
      }
      localIOException1.printStackTrace();
    }
  }
  
  public void a(InfomationFacePackage paramInfomationFacePackage, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.b;
    label31:
    Object localObject1;
    Object localObject3;
    URLImageView localURLImageView;
    Object localObject2;
    QIMCommonLoadingView localQIMCommonLoadingView;
    if (paramInt1 == paramInt2 - 1)
    {
      paramInt1 = paramInfomationFacePackage.b();
      a(paramInt1 - i);
      paramInt2 = i;
      if (paramInt2 >= paramInt1) {
        return;
      }
      localObject1 = getChildAt(paramInt2 - i);
      localObject3 = ((View)localObject1).findViewById(2131371827);
      localURLImageView = (URLImageView)((View)localObject1).findViewById(2131371828);
      localObject2 = (ProgressBar)((View)localObject1).findViewById(2131371830);
      localQIMCommonLoadingView = (QIMCommonLoadingView)((View)localObject1).findViewById(2131371829);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
        break label153;
      }
      localObject1 = paramInfomationFacePackage.b(paramInt2);
      label111:
      if (localObject1 != null) {
        break label163;
      }
      SLog.e("InformationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramInfomationFacePackage.toString() });
    }
    for (;;)
    {
      paramInt2 += 1;
      break label31;
      paramInt1 = this.b + i;
      break;
      label153:
      localObject1 = paramInfomationFacePackage.a(paramInt2);
      break label111;
      label163:
      ((View)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localURLImageView.setTag(2131362359, Integer.valueOf(paramInt2));
      localObject3 = (Boolean)localURLImageView.getTag(2131362361);
      if ((localObject3 != null) && (((Boolean)localObject3).booleanValue()) && (((String)localObject1).equals(localURLImageView.getTag(2131362360))))
      {
        ((ProgressBar)localObject2).setVisibility(4);
      }
      else
      {
        localURLImageView.setTag(2131362360, localObject1);
        localURLImageView.setTag(2131362361, Boolean.valueOf(false));
        ((ProgressBar)localObject2).setVisibility(0);
        localObject1 = new aoaw((String)localObject1, localURLImageView, (ProgressBar)localObject2);
        localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject1);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity))
        {
          localObject2 = a((InfomationFacePackage.Item)paramInfomationFacePackage.a.get(paramInt2));
          if (localObject2 != null)
          {
            if (((URLDrawable)localObject2).getStatus() != 1) {
              ((URLDrawable)localObject2).restartDownload();
            }
            if (((URLDrawable)localObject2).getStatus() == 1) {
              ((aoaw)localObject1).onLoadSuccessed(localURLImageView, (URLDrawable)localObject2);
            }
            localURLImageView.setImageDrawable((Drawable)localObject2);
          }
        }
        else
        {
          a((InfomationFacePackage.Item)paramInfomationFacePackage.a.get(paramInt2), localURLImageView, localQIMCommonLoadingView, (ProgressBar)localObject2, (aoaw)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoas
 * JD-Core Version:    0.7.0.1
 */