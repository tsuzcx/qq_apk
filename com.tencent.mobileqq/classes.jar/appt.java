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

public class appt
  extends aqpk
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private aozt jdField_a_of_type_Aozt;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, List<appx>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b;
  
  public appt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = Color.parseColor("#00CAFC");
    this.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ChatTextSizeSettingActivity.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 21.0F));
    b();
  }
  
  private void a(apps paramapps, RoundImageView paramRoundImageView, aqoi paramaqoi)
  {
    if (paramapps.jdField_a_of_type_Boolean)
    {
      paramapps = nmy.a(paramapps.jdField_a_of_type_Int);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      localObject = URLDrawable.getDrawable(paramapps, (URLDrawable.URLDrawableOptions)localObject);
      if (localObject != null)
      {
        if (((URLDrawable)localObject).getStatus() == 1) {
          paramRoundImageView.setImageDrawable((Drawable)localObject);
        }
      }
      else {
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new appv(this, paramRoundImageView, paramaqoi, paramapps));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramapps.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new appx(this, paramRoundImageView, paramaqoi));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramapps.jdField_a_of_type_JavaLangString, localObject);
    paramRoundImageView.setImageBitmap(this.jdField_a_of_type_Aozt.a(paramapps.jdField_a_of_type_JavaLangString, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aozt = new aozt(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Aozt.a();
    this.jdField_a_of_type_Aozt.a(new appu(this));
  }
  
  public aqpl a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558931, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new appw(this, localView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aozt != null) {
      this.jdField_a_of_type_Aozt.b();
    }
  }
  
  public void a(int paramInt, aqpl paramaqpl, aqoi paramaqoi)
  {
    apps localapps;
    ETTextView localETTextView;
    if ((paramaqoi != null) && ((paramaqoi.a() instanceof apps)) && ((paramaqpl instanceof appw)))
    {
      localapps = (apps)paramaqoi.a();
      paramaqpl = (appw)paramaqpl;
      paramaqpl.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(localapps.a(), 3, this.b));
      localETTextView = paramaqpl.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (!a(localapps.jdField_a_of_type_JavaLangString)) {
        break label110;
      }
    }
    label110:
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = -1)
    {
      localETTextView.setTextColor(paramInt);
      paramaqpl.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setAlpha(0.85F);
      a(localapps, paramaqpl.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramaqoi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appt
 * JD-Core Version:    0.7.0.1
 */