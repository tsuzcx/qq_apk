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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class aqsx
  extends arsv
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private aqcx jdField_a_of_type_Aqcx;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, List<aqtb>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b;
  
  public aqsx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = Color.parseColor("#00CAFC");
    this.jdField_a_of_type_AndroidGraphicsBitmap = bheg.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ChatTextSizeSettingActivity.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 21.0F));
    b();
  }
  
  private void a(aqsw paramaqsw, RoundImageView paramRoundImageView, arrt paramarrt)
  {
    if (paramaqsw.jdField_a_of_type_Boolean)
    {
      paramaqsw = nty.a(paramaqsw.jdField_a_of_type_Int);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      localObject = URLDrawable.getDrawable(paramaqsw, (URLDrawable.URLDrawableOptions)localObject);
      if (localObject != null)
      {
        if (((URLDrawable)localObject).getStatus() == 1) {
          paramRoundImageView.setImageDrawable((Drawable)localObject);
        }
      }
      else {
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new aqsz(this, paramRoundImageView, paramarrt, paramaqsw));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaqsw.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new aqtb(this, paramRoundImageView, paramarrt));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaqsw.jdField_a_of_type_JavaLangString, localObject);
    paramRoundImageView.setImageBitmap(this.jdField_a_of_type_Aqcx.a(paramaqsw.jdField_a_of_type_JavaLangString, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aqcx = new aqcx(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Aqcx.a();
    this.jdField_a_of_type_Aqcx.a(new aqsy(this));
  }
  
  public arsw a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558958, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new aqta(this, localView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqcx != null) {
      this.jdField_a_of_type_Aqcx.b();
    }
  }
  
  public void a(int paramInt, arsw paramarsw, arrt paramarrt)
  {
    aqsw localaqsw;
    ETTextView localETTextView;
    if ((paramarrt != null) && ((paramarrt.a() instanceof aqsw)) && ((paramarsw instanceof aqta)))
    {
      localaqsw = (aqsw)paramarrt.a();
      paramarsw = (aqta)paramarsw;
      paramarsw.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(localaqsw.a(), 3, this.b));
      localETTextView = paramarsw.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (!a(localaqsw.jdField_a_of_type_JavaLangString)) {
        break label110;
      }
    }
    label110:
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = -1)
    {
      localETTextView.setTextColor(paramInt);
      paramarsw.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setAlpha(0.85F);
      a(localaqsw, paramarsw.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramarrt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsx
 * JD-Core Version:    0.7.0.1
 */