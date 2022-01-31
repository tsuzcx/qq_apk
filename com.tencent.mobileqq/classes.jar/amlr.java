import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class amlr
  extends anhf
{
  private int jdField_a_of_type_Int;
  private alxg jdField_a_of_type_Alxg;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, List<amlv>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b;
  
  public amlr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = Color.parseColor("#00CAFC");
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbdr.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ChatTextSizeSettingActivity.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, bawz.a(paramContext, 21.0F));
    b();
  }
  
  private void a(amlq paramamlq, RoundImageView paramRoundImageView, angd paramangd)
  {
    if (paramamlq.jdField_a_of_type_Boolean)
    {
      paramamlq = mye.a(paramamlq.jdField_a_of_type_Int);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      localObject = URLDrawable.getDrawable(paramamlq, (URLDrawable.URLDrawableOptions)localObject);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramRoundImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new amlt(this, paramRoundImageView, paramangd, paramamlq));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamlq.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new amlv(this, paramRoundImageView, paramangd));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramamlq.jdField_a_of_type_JavaLangString, localObject);
    paramRoundImageView.setImageBitmap(this.jdField_a_of_type_Alxg.a(paramamlq.jdField_a_of_type_JavaLangString, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Alxg.a();
    this.jdField_a_of_type_Alxg.a(new amls(this));
  }
  
  public anhg a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558817, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new amlu(this, localView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alxg != null) {
      this.jdField_a_of_type_Alxg.b();
    }
  }
  
  public void a(int paramInt, anhg paramanhg, angd paramangd)
  {
    amlq localamlq;
    ETTextView localETTextView;
    if ((paramangd != null) && ((paramangd.a() instanceof amlq)) && ((paramanhg instanceof amlu)))
    {
      localamlq = (amlq)paramangd.a();
      paramanhg = (amlu)paramanhg;
      paramanhg.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new ayki(localamlq.a(), 13, this.b));
      localETTextView = paramanhg.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (!a(localamlq.jdField_a_of_type_JavaLangString)) {
        break label111;
      }
    }
    label111:
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = -1)
    {
      localETTextView.setTextColor(paramInt);
      paramanhg.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setAlpha(0.85F);
      a(localamlq, paramanhg.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramangd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */