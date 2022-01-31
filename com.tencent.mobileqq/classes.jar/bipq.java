import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter.1;
import java.io.File;

public class bipq
  extends bipb<biox>
  implements View.OnClickListener
{
  private bipc<String, Drawable> a;
  
  public bipq(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bipc = new bipc();
  }
  
  private void a(View paramView)
  {
    ImageView localImageView = (ImageView)paramView;
    int k = ((Integer)localImageView.getTag(2131311062)).intValue();
    biox localbiox = (biox)this.jdField_a_of_type_Bion;
    urp.a((Activity)paramView.getContext(), "sticker_element", ((biox)this.jdField_a_of_type_Bion).jdField_a_of_type_JavaLangString, String.valueOf(k));
    int j = localbiox.a(k);
    paramView = Uri.parse(localbiox.a(k)).getPath();
    String str = new File(paramView).getName();
    Object localObject1 = paramView;
    int i = j;
    if (j == 1)
    {
      localObject1 = paramView;
      i = j;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity))
      {
        localObject2 = localbiox.b(k);
        localObject1 = paramView;
        i = j;
        if (localObject2 != null)
        {
          localObject1 = Uri.parse((String)localObject2).getPath();
          i = 0;
        }
      }
    }
    paramView = (Drawable)this.jdField_a_of_type_Bipc.a(localObject1);
    if (paramView == null) {
      if (i != 1)
      {
        try
        {
          localObject2 = Drawable.createFromPath((String)localObject1);
          paramView = (View)localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            urk.c("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
          }
        }
        localObject2 = paramView;
        if (paramView != null) {
          this.jdField_a_of_type_Bipc.a(localObject1, paramView);
        }
      }
    }
    Object localObject3;
    for (Object localObject2 = paramView;; localObject3 = paramView)
    {
      if (localObject2 == null) {
        break label404;
      }
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      a(localbiox, (Drawable)localObject2, localImageView, (String)localObject1, str, i);
      return;
      localObject3 = baop.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      if (localObject3 != null)
      {
        j = ((URLDrawable)localObject3).getStatus();
        if (j != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NormalFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + j);
          }
          if (j == 2)
          {
            ((URLDrawable)localObject3).restartDownload();
            label336:
            ((URLDrawable)localObject3).setURLDrawableListener(new bipr(this, (String)localObject1, localbiox, localImageView, str));
          }
        }
        for (;;)
        {
          break;
          ((URLDrawable)localObject3).startDownload();
          break label336;
          paramView = (View)localObject3;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
      }
      break;
      this.jdField_a_of_type_Bipc.a();
    }
    label404:
    urk.e("NormalFaceAdapter", "can create drawable from path:" + (String)localObject1);
  }
  
  private void a(biox parambiox, Drawable paramDrawable, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    int i;
    int k;
    int j;
    if (paramDrawable.getIntrinsicWidth() > paramDrawable.getIntrinsicHeight())
    {
      i = paramDrawable.getIntrinsicWidth();
      k = paramImageView.getWidth();
      if (paramImageView.getPaddingLeft() <= paramImageView.getPaddingTop()) {
        break label136;
      }
      j = paramImageView.getPaddingLeft();
      label40:
      if (k <= i) {
        break label145;
      }
    }
    label136:
    label145:
    for (float f = (((k - i) / 2 - j) * 2 + i) / i;; f = (i - (j + (i - k) / 2) * 2) / i)
    {
      f = (float)(f * parambiox.jdField_a_of_type_Double);
      parambiox = new bikj(parambiox.b, paramString2, paramDrawable, paramInt);
      paramDrawable = bhoe.a();
      this.jdField_a_of_type_Bhhl.a(parambiox, paramDrawable.a, paramDrawable.b, f, paramString1, null);
      return;
      i = paramDrawable.getIntrinsicHeight();
      break;
      j = paramImageView.getPaddingTop();
      break label40;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bion == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bips(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((biox)this.jdField_a_of_type_Bion).a(), ((biox)this.jdField_a_of_type_Bion).a(), this, this);; paramView = (bips)paramView)
    {
      paramView.a((biox)this.jdField_a_of_type_Bion, paramInt, getCount(), a());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.postImmediately(new NormalFaceAdapter.1(this, paramView), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipq
 * JD-Core Version:    0.7.0.1
 */