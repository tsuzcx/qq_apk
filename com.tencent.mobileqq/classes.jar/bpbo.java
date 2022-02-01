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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.2;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;

public class bpbo
  extends bpbj<bpax>
  implements View.OnClickListener
{
  private bpbk<String, Drawable> a;
  
  public bpbo(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bpbk = new bpbk();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new boww(((bpax)this.jdField_a_of_type_Bpaw).b, paramString2, paramDrawable, paramInt);
    paramString2 = bonh.a();
    this.jdField_a_of_type_Boid.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((bpax)this.jdField_a_of_type_Bpaw).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(bpba parambpba)
  {
    int j = 7;
    String str = bojy.b(parambpba);
    Object localObject1 = ".apng";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (parambpba.jdField_a_of_type_Int == 8)
      {
        k = Calendar.getInstance().get(7) - 1;
        if (k != 0) {
          break label478;
        }
      }
      for (;;)
      {
        for (str = str + File.separator + j + (String)localObject1;; str = str + File.separator + "city" + (String)localObject1)
        {
          localObject2 = (Drawable)this.jdField_a_of_type_Bpbk.a(str);
          if (localObject2 != null) {
            break label442;
          }
          if (i == 1) {
            break label299;
          }
          localObject1 = BitmapFactory.decodeFile(str);
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("InformationFaceAdapter", 2, "InformationFaceAdapter decodeFile path:" + str + ",bitmap is null");
          }
          a(str);
          return;
        }
        ((Bitmap)localObject1).setDensity(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi);
        localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1);
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Bpbk.a(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, parambpba.b, i);
          return;
          label299:
          localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
          if (localObject1 != null)
          {
            j = ((URLDrawable)localObject1).getStatus();
            if (j != 1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("InformationFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + j);
              }
              if (j == 2) {
                ((URLDrawable)localObject1).restartDownload();
              }
              for (;;)
              {
                ((URLDrawable)localObject1).setURLDrawableListener(new bpbp(this, str, parambpba));
                localObject1 = localObject2;
                break;
                ((URLDrawable)localObject1).startDownload();
              }
            }
            break;
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("InformationFaceAdapter", 2, "urlDrawable apng error");
          localObject1 = localObject2;
          break;
          label442:
          this.jdField_a_of_type_Bpbk.a();
        }
        label452:
        ykq.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(Boolean paramBoolean, bpba parambpba)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (parambpba.jdField_a_of_type_Int == 8) {
        a(parambpba);
      }
    }
    else {
      return;
    }
    if ((bpbb.a(parambpba.jdField_a_of_type_Int)) && ("default".equals(((bpax)this.jdField_a_of_type_Bpaw).g)))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131699188, 0).show();
      return;
    }
    float f = (float)((bpax)this.jdField_a_of_type_Bpaw).jdField_a_of_type_Double;
    paramBoolean = bonh.a();
    this.jdField_a_of_type_Boid.a(parambpba, null, paramBoolean.jdField_a_of_type_Int, paramBoolean.b, f);
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, anvx.a(2131705242), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bpaw == null) {
      localObject = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {
        localObject = new bpbr(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bpax)this.jdField_a_of_type_Bpaw).a(), ((bpax)this.jdField_a_of_type_Bpaw).a(), this, this);
      }
      try
      {
        for (;;)
        {
          ((bpbr)localObject).a((bpax)this.jdField_a_of_type_Bpaw, paramInt, getCount(), a());
          break;
          localObject = (bpbr)paramView;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131368890);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131368889);
    int i = ((Integer)localImageView.getTag(2131378482)).intValue();
    bpba localbpba = (bpba)((bpax)this.jdField_a_of_type_Bpaw).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378460);
    bojy localbojy = (bojy)bogd.a().c(12);
    if (localbojy.a(localbpba)) {
      a(localBoolean, localbpba);
    }
    for (;;)
    {
      ykv.a((Activity)paramView.getContext(), "sticker_element", ((bpax)this.jdField_a_of_type_Bpaw).jdField_a_of_type_JavaLangString, localbpba.jdField_a_of_type_JavaLangString);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isNetworkAvailable(paramView.getContext())) {
        localbojy.a((bpba)((bpax)this.jdField_a_of_type_Bpaw).jdField_a_of_type_JavaUtilList.get(i), new bpbq(this, localQIMCommonLoadingView, localImageView));
      } else {
        QQToast.a(paramView.getContext(), 0, anvx.a(2131705244), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbo
 * JD-Core Version:    0.7.0.1
 */