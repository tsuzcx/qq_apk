package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil.Position;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;

public class InformationFaceAdapter
  extends BaseFaceListAdapter<InformationFacePackage>
  implements View.OnClickListener
{
  private BaseFaceListAdapter.CacheRefMap<String, Drawable> a;
  
  public InformationFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter$CacheRefMap = new BaseFaceListAdapter.CacheRefMap();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new SelectedItem(((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).b, paramString2, paramDrawable, paramInt);
    paramString2 = PasterUtil.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(InformationFacePackage.Item paramItem)
  {
    String str = InfoStickerSaveUtils.b(paramItem);
    Object localObject1;
    int i;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity))
    {
      localObject1 = ".bpng";
      i = 0;
    }
    else
    {
      localObject1 = ".apng";
      i = 1;
    }
    int j;
    if (paramItem.jdField_a_of_type_Int == 8)
    {
      int k = Calendar.getInstance().get(7) - 1;
      j = k;
      if (k == 0) {
        j = 7;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("city");
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = (Drawable)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter$CacheRefMap.a(str);
    if (localObject2 == null)
    {
      if (i != 1)
      {
        localObject1 = BitmapFactory.decodeFile(str);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel())
          {
            paramItem = new StringBuilder();
            paramItem.append("InformationFaceAdapter decodeFile path:");
            paramItem.append(str);
            paramItem.append(",bitmap is null");
            QLog.e("InformationFaceAdapter", 2, paramItem.toString());
          }
          a(str);
          return;
        }
        ((Bitmap)localObject1).setDensity(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi);
        localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1);
      }
      else
      {
        localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 != null)
        {
          j = ((URLDrawable)localObject1).getStatus();
          if (j != 1)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("urlDrawable is not  SUCCESSED :");
              localStringBuilder.append(j);
              QLog.e("InformationFaceAdapter", 2, localStringBuilder.toString());
            }
            if (j == 2) {
              ((URLDrawable)localObject1).restartDownload();
            } else {
              ((URLDrawable)localObject1).startDownload();
            }
            ((URLDrawable)localObject1).setURLDrawableListener(new InformationFaceAdapter.1(this, str, paramItem));
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("InformationFaceAdapter", 2, "urlDrawable apng error");
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter$CacheRefMap.a(str, localObject1);
        localObject2 = localObject1;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter$CacheRefMap.a();
    }
    if (localObject2 != null)
    {
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      a((Drawable)localObject2, str, paramItem.b, i);
      return;
    }
    paramItem = new StringBuilder();
    paramItem.append("can create drawable from path:");
    paramItem.append(str);
    SLog.e("InformationFaceAdapter", paramItem.toString());
  }
  
  private void a(Boolean paramBoolean, InformationFacePackage.Item paramItem)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (paramItem.jdField_a_of_type_Int == 8)
      {
        a(paramItem);
        return;
      }
      if ((InformationFaceConstant.a(paramItem.jdField_a_of_type_Int)) && ("default".equals(((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).g)))
      {
        Toast.makeText(BaseApplicationImpl.getContext(), 2131699907, 0).show();
        return;
      }
      float f = (float)((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).jdField_a_of_type_Double;
      paramBoolean = PasterUtil.a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener.a(paramItem, null, paramBoolean.jdField_a_of_type_Int, paramBoolean.b, f);
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705845), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage == null) {
      return paramView;
    }
    if (paramView == null) {
      paramView = new InformationFaceAdapter.InformationItemLayout(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).a(), ((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).a(), this, this);
    } else {
      paramView = (InformationFaceAdapter.InformationItemLayout)paramView;
    }
    try
    {
      paramView.a((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage, paramInt, getCount(), a());
      return paramView;
    }
    catch (MalformedURLException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131368855);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131368854);
    int i = ((Integer)localImageView.getTag(2131378301)).intValue();
    InformationFacePackage.Item localItem = (InformationFacePackage.Item)((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378280);
    QIMInformationPasterManager localQIMInformationPasterManager = (QIMInformationPasterManager)QIMManager.a().c(12);
    if (localQIMInformationPasterManager.a(localItem)) {
      a(localBoolean, localItem);
    } else if (NetworkUtil.isNetworkAvailable(paramView.getContext())) {
      localQIMInformationPasterManager.a((InformationFacePackage.Item)((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).jdField_a_of_type_JavaUtilList.get(i), new InformationFaceAdapter.DownloadProgressCallback(this, localQIMCommonLoadingView, localImageView));
    } else {
      QQToast.a(paramView.getContext(), 0, HardCodeUtil.a(2131705846), 0).a();
    }
    StoryReportor.a((Activity)paramView.getContext(), "sticker_element", ((InformationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).jdField_a_of_type_JavaLangString, localItem.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */