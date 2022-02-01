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

public class bnlw
  extends bnlr<bnlf>
  implements View.OnClickListener
{
  private bnls<String, Drawable> a;
  
  public bnlw(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bnls = new bnls();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new bnhe(((bnlf)this.jdField_a_of_type_Bnle).b, paramString2, paramDrawable, paramInt);
    paramString2 = bmxp.a();
    this.jdField_a_of_type_Bmsl.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((bnlf)this.jdField_a_of_type_Bnle).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(bnli parambnli)
  {
    int j = 7;
    String str = bmug.b(parambnli);
    Object localObject1 = ".apng";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (parambnli.jdField_a_of_type_Int == 8)
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
          localObject2 = (Drawable)this.jdField_a_of_type_Bnls.a(str);
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
          this.jdField_a_of_type_Bnls.a(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, parambnli.b, i);
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
                ((URLDrawable)localObject1).setURLDrawableListener(new bnlx(this, str, parambnli));
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
          this.jdField_a_of_type_Bnls.a();
        }
        label452:
        xvv.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(Boolean paramBoolean, bnli parambnli)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (parambnli.jdField_a_of_type_Int == 8) {
        a(parambnli);
      }
    }
    else {
      return;
    }
    if ((bnlj.a(parambnli.jdField_a_of_type_Int)) && ("default".equals(((bnlf)this.jdField_a_of_type_Bnle).g)))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131698837, 0).show();
      return;
    }
    float f = (float)((bnlf)this.jdField_a_of_type_Bnle).jdField_a_of_type_Double;
    paramBoolean = bmxp.a();
    this.jdField_a_of_type_Bmsl.a(parambnli, null, paramBoolean.jdField_a_of_type_Int, paramBoolean.b, f);
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, amtj.a(2131704891), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bnle == null) {
      localObject = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {
        localObject = new bnlz(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bnlf)this.jdField_a_of_type_Bnle).a(), ((bnlf)this.jdField_a_of_type_Bnle).a(), this, this);
      }
      try
      {
        for (;;)
        {
          ((bnlz)localObject).a((bnlf)this.jdField_a_of_type_Bnle, paramInt, getCount(), a());
          break;
          localObject = (bnlz)paramView;
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
    ImageView localImageView = (ImageView)paramView.findViewById(2131368731);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131368730);
    int i = ((Integer)localImageView.getTag(2131378194)).intValue();
    bnli localbnli = (bnli)((bnlf)this.jdField_a_of_type_Bnle).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378172);
    bmug localbmug = (bmug)bmql.a().c(12);
    if (localbmug.a(localbnli)) {
      a(localBoolean, localbnli);
    }
    for (;;)
    {
      xwa.a((Activity)paramView.getContext(), "sticker_element", ((bnlf)this.jdField_a_of_type_Bnle).jdField_a_of_type_JavaLangString, localbnli.jdField_a_of_type_JavaLangString);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isNetworkAvailable(paramView.getContext())) {
        localbmug.a((bnli)((bnlf)this.jdField_a_of_type_Bnle).jdField_a_of_type_JavaUtilList.get(i), new bnly(this, localQIMCommonLoadingView, localImageView));
      } else {
        QQToast.a(paramView.getContext(), 0, amtj.a(2131704893), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlw
 * JD-Core Version:    0.7.0.1
 */