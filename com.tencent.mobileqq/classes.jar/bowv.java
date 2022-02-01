import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.1;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.3;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class bowv
  extends RecyclerView.ViewHolder
  implements bozc, URLDrawable.URLDrawableListener2
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = b().getResources().getDrawable(2130837668);
  private static final Map<String, WeakReference<URLDrawable>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final String jdField_b_of_type_JavaLangString;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  boqu jdField_a_of_type_Boqu;
  private bowx jdField_a_of_type_Bowx;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private final String jdField_a_of_type_JavaLangString = "AEPlayShowGridViewHolder";
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private String c = "";
  private String d = "";
  private String e = "";
  
  static
  {
    File localFile = new File(bofb.jdField_a_of_type_JavaLangString, "play_show_apng");
    jdField_b_of_type_JavaLangString = localFile.getPath();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public bowv(View paramView, bowu parambowu, bowx parambowx, int paramInt)
  {
    super(paramView);
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt == 1) {
      paramView.post(new AEPlayShowGridViewHolder.1(this, paramView));
    }
    this.jdField_a_of_type_Bowx = parambowx;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362279));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362280);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362283));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131362282));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362281);
    parambowx = paramView.getLayoutParams();
    parambowx.width = parambowu.jdField_a_of_type_Int;
    parambowx.height = parambowu.jdField_b_of_type_Int;
    paramView.setLayoutParams(parambowx);
    paramView.setOnClickListener(new boww(this));
  }
  
  private URLDrawable a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return VasApngUtil.getApngDrawable(paramString1, paramString2, jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, "-GY-PLAY-SHOW-", null);
  }
  
  private void a(@NonNull boqu paramboqu)
  {
    this.c = paramboqu.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramboqu.m)) {}
    for (String str = "";; str = paramboqu.m)
    {
      this.d = str;
      this.e = paramboqu.l;
      paramboqu = jdField_b_of_type_JavaLangString + File.separator + this.e.hashCode() + "_" + this.c.hashCode() + ".png";
      c();
      this.jdField_a_of_type_ComTencentImageURLDrawable = a(paramboqu, this.e);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      return;
    }
  }
  
  private static Context b()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_b_of_type_Int != 1) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a(@NonNull boqu paramboqu, int paramInt)
  {
    this.jdField_a_of_type_Boqu = paramboqu;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    a(paramboqu);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.3(this, paramInt));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))) {
      return;
    }
    bpam.b("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish id:" + paramString);
    bpam.b("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish isSuccess:" + paramBoolean);
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.4(this, paramBoolean));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowv
 * JD-Core Version:    0.7.0.1
 */