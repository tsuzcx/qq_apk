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
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.1;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.3;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class blgd
  extends RecyclerView.ViewHolder
  implements blif, URLDrawable.URLDrawableListener2
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = b().getResources().getDrawable(2130837603);
  private static final Map<String, WeakReference<URLDrawable>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final String jdField_b_of_type_JavaLangString;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  blab jdField_a_of_type_Blab;
  private blgf jdField_a_of_type_Blgf;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private final String jdField_a_of_type_JavaLangString = "AEPlayShowGridViewHolder";
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private String c = "";
  private String d = "";
  private String e = "";
  
  static
  {
    File localFile = new File(bkpf.jdField_a_of_type_JavaLangString, "play_show_apng");
    jdField_b_of_type_JavaLangString = localFile.getPath();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public blgd(View paramView, blgc paramblgc, blgf paramblgf, int paramInt)
  {
    super(paramView);
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt == 1) {
      paramView.post(new AEPlayShowGridViewHolder.1(this, paramView));
    }
    this.jdField_a_of_type_Blgf = paramblgf;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362197));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362198);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362201));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131362200));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362199);
    paramblgf = paramView.getLayoutParams();
    paramblgf.width = paramblgc.jdField_a_of_type_Int;
    paramblgf.height = paramblgc.jdField_b_of_type_Int;
    paramView.setLayoutParams(paramblgf);
    paramView.setOnClickListener(new blge(this));
  }
  
  private URLDrawable a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return bduc.a(paramString1, paramString2, jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, "-GY-PLAY-SHOW-", null);
  }
  
  private void a(@NonNull blab paramblab)
  {
    this.c = paramblab.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramblab.l)) {}
    for (String str = "";; str = paramblab.l)
    {
      this.d = str;
      this.e = paramblab.k;
      paramblab = jdField_b_of_type_JavaLangString + File.separator + this.e.hashCode() + "_" + this.c.hashCode() + ".png";
      c();
      this.jdField_a_of_type_ComTencentImageURLDrawable = a(paramblab, this.e);
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
  
  public void a(@NonNull blab paramblab, int paramInt)
  {
    this.jdField_a_of_type_Blab = paramblab;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    a(paramblab);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.3(this, paramInt));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))) {
      return;
    }
    bljn.b("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish id:" + paramString);
    bljn.b("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish isSuccess:" + paramBoolean);
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
 * Qualified Name:     blgd
 * JD-Core Version:    0.7.0.1
 */