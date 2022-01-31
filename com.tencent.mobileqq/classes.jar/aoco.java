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

public class aoco
  extends aoyr
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private anoe jdField_a_of_type_Anoe;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, List<aocs>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b;
  
  public aoco(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = Color.parseColor("#00CAFC");
    this.jdField_a_of_type_AndroidGraphicsBitmap = bdda.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ChatTextSizeSettingActivity.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, bcwh.a(paramContext, 21.0F));
    b();
  }
  
  private void a(aocn paramaocn, RoundImageView paramRoundImageView, aoxp paramaoxp)
  {
    if (paramaocn.jdField_a_of_type_Boolean)
    {
      paramaocn = nav.a(paramaocn.jdField_a_of_type_Int);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      localObject = URLDrawable.getDrawable(paramaocn, (URLDrawable.URLDrawableOptions)localObject);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramRoundImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new aocq(this, paramRoundImageView, paramaoxp, paramaocn));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaocn.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new aocs(this, paramRoundImageView, paramaoxp));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaocn.jdField_a_of_type_JavaLangString, localObject);
    paramRoundImageView.setImageBitmap(this.jdField_a_of_type_Anoe.a(paramaocn.jdField_a_of_type_JavaLangString, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Anoe = new anoe(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Anoe.a();
    this.jdField_a_of_type_Anoe.a(new aocp(this));
  }
  
  public aoys a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558853, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new aocr(this, localView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anoe != null) {
      this.jdField_a_of_type_Anoe.b();
    }
  }
  
  public void a(int paramInt, aoys paramaoys, aoxp paramaoxp)
  {
    aocn localaocn;
    ETTextView localETTextView;
    if ((paramaoxp != null) && ((paramaoxp.a() instanceof aocn)) && ((paramaoys instanceof aocr)))
    {
      localaocn = (aocn)paramaoxp.a();
      paramaoys = (aocr)paramaoys;
      paramaoys.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new baig(localaocn.a(), 3, this.b));
      localETTextView = paramaoys.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (!a(localaocn.jdField_a_of_type_JavaLangString)) {
        break label110;
      }
    }
    label110:
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = -1)
    {
      localETTextView.setTextColor(paramInt);
      paramaoys.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setAlpha(0.85F);
      a(localaocn, paramaoys.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramaoxp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoco
 * JD-Core Version:    0.7.0.1
 */