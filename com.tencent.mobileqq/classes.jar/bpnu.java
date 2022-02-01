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

public class bpnu
  extends bpnp<bpnc>
  implements View.OnClickListener
{
  private bpnq<String, Drawable> a;
  
  public bpnu(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bpnq = new bpnq();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new bpix(((bpnc)this.jdField_a_of_type_Bpnb).b, paramString2, paramDrawable, paramInt);
    paramString2 = boso.a();
    this.jdField_a_of_type_Bolv.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((bpnc)this.jdField_a_of_type_Bpnb).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(bpnf parambpnf)
  {
    int j = 7;
    String str = boos.b(parambpnf);
    Object localObject1 = ".apng";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (parambpnf.jdField_a_of_type_Int == 8)
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
          localObject2 = (Drawable)this.jdField_a_of_type_Bpnq.a(str);
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
          this.jdField_a_of_type_Bpnq.a(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, parambpnf.b, i);
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
                ((URLDrawable)localObject1).setURLDrawableListener(new bpnv(this, str, parambpnf));
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
          this.jdField_a_of_type_Bpnq.a();
        }
        label452:
        yqp.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(Boolean paramBoolean, bpnf parambpnf)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (parambpnf.jdField_a_of_type_Int == 8) {
        a(parambpnf);
      }
    }
    else {
      return;
    }
    if ((bpng.a(parambpnf.jdField_a_of_type_Int)) && ("default".equals(((bpnc)this.jdField_a_of_type_Bpnb).g)))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131698495, 0).show();
      return;
    }
    float f = (float)((bpnc)this.jdField_a_of_type_Bpnb).jdField_a_of_type_Double;
    paramBoolean = boso.a();
    this.jdField_a_of_type_Bolv.a(parambpnf, null, paramBoolean.jdField_a_of_type_Int, paramBoolean.b, f);
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, anni.a(2131704554), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bpnb == null) {
      localObject = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {
        localObject = new bpnx(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bpnc)this.jdField_a_of_type_Bpnb).a(), ((bpnc)this.jdField_a_of_type_Bpnb).a(), this, this);
      }
      try
      {
        for (;;)
        {
          ((bpnx)localObject).a((bpnc)this.jdField_a_of_type_Bpnb, paramInt, getCount(), a());
          break;
          localObject = (bpnx)paramView;
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
    ImageView localImageView = (ImageView)paramView.findViewById(2131368634);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131368633);
    int i = ((Integer)localImageView.getTag(2131378270)).intValue();
    bpnf localbpnf = (bpnf)((bpnc)this.jdField_a_of_type_Bpnb).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378248);
    boos localboos = (boos)bojv.a().c(12);
    if (localboos.a(localbpnf)) {
      a(localBoolean, localbpnf);
    }
    for (;;)
    {
      yqu.a((Activity)paramView.getContext(), "sticker_element", ((bpnc)this.jdField_a_of_type_Bpnb).jdField_a_of_type_JavaLangString, localbpnf.jdField_a_of_type_JavaLangString);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bgnt.g(paramView.getContext())) {
        localboos.a((bpnf)((bpnc)this.jdField_a_of_type_Bpnb).jdField_a_of_type_JavaUtilList.get(i), new bpnw(this, localQIMCommonLoadingView, localImageView));
      } else {
        QQToast.a(paramView.getContext(), 0, anni.a(2131704556), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnu
 * JD-Core Version:    0.7.0.1
 */