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

public class aogx
  extends apda
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ansn jdField_a_of_type_Ansn;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, List<aohb>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b;
  
  public aogx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = Color.parseColor("#00CAFC");
    this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ChatTextSizeSettingActivity.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, bdaq.a(paramContext, 21.0F));
    b();
  }
  
  private void a(aogw paramaogw, RoundImageView paramRoundImageView, apby paramapby)
  {
    if (paramaogw.jdField_a_of_type_Boolean)
    {
      paramaogw = nav.a(paramaogw.jdField_a_of_type_Int);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      localObject = URLDrawable.getDrawable(paramaogw, (URLDrawable.URLDrawableOptions)localObject);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramRoundImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new aogz(this, paramRoundImageView, paramapby, paramaogw));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaogw.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new aohb(this, paramRoundImageView, paramapby));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaogw.jdField_a_of_type_JavaLangString, localObject);
    paramRoundImageView.setImageBitmap(this.jdField_a_of_type_Ansn.a(paramaogw.jdField_a_of_type_JavaLangString, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Ansn = new ansn(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Ansn.a();
    this.jdField_a_of_type_Ansn.a(new aogy(this));
  }
  
  public apdb a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558852, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new aoha(this, localView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ansn != null) {
      this.jdField_a_of_type_Ansn.b();
    }
  }
  
  public void a(int paramInt, apdb paramapdb, apby paramapby)
  {
    aogw localaogw;
    ETTextView localETTextView;
    if ((paramapby != null) && ((paramapby.a() instanceof aogw)) && ((paramapdb instanceof aoha)))
    {
      localaogw = (aogw)paramapby.a();
      paramapdb = (aoha)paramapdb;
      paramapdb.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new bamp(localaogw.a(), 3, this.b));
      localETTextView = paramapdb.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (!a(localaogw.jdField_a_of_type_JavaLangString)) {
        break label110;
      }
    }
    label110:
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = -1)
    {
      localETTextView.setTextColor(paramInt);
      paramapdb.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setAlpha(0.85F);
      a(localaogw, paramapdb.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramapby);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogx
 * JD-Core Version:    0.7.0.1
 */