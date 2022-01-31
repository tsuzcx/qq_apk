import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import cooperation.vip.manager.ExtendKuolieGdtAdvCanvasFragment;
import cooperation.vip.manager.albumGdtCanvasFragment;
import cooperation.vip.widget.VipGeneralGdtShowView.2;
import java.lang.ref.WeakReference;

public class biay
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new biaz(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bibb jdField_a_of_type_Bibb;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private AlumBasicData jdField_a_of_type_CooperationVipJsoninflateModelAlumBasicData;
  public final String a;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int f;
  
  public biay(Context paramContext, int paramInt1, int paramInt2, int paramInt3, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_JavaLangString = "VipGeneralGdtShowView";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (paramGdtAppReceiver == null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt3;
      return;
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = paramGdtAppReceiver;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public Class<? extends GdtCanvasBaseFragment> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return albumGdtCanvasFragment.class;
    }
    return ExtendKuolieGdtAdvCanvasFragment.class;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bhzc.a().a(this.jdField_c_of_type_Int, 0L, paramInt1, paramString, paramInt2);
      return;
    }
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo sendBusinessReport");
  }
  
  public void a(View paramView, bibb parambibb)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Bibb = parambibb;
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo initAdvView");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366987));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366990));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366991));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366993));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366989));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366994));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366995));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366992));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(AlumBasicData paramAlumBasicData, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        this.jdField_a_of_type_CooperationVipJsoninflateModelAlumBasicData = paramAlumBasicData;
        this.jdField_b_of_type_Int = (paramInt + 1);
        if ((paramAlumBasicData == null) || (TextUtils.isEmpty(paramAlumBasicData.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null))
        {
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          QZLog.i("VipGeneralGdtShowView", " @getGdtInfo setDataChanged is null");
          return;
        }
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramAlumBasicData.jdField_b_of_type_JavaLangString, null);
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getDrawable(2130839736);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mUseMemoryCache = false;
        localObject1 = URLDrawable.getDrawable(paramAlumBasicData.j, (URLDrawable.URLDrawableOptions)localObject2);
        if ((this.jdField_c_of_type_Int == 3) && (!axmt.b()))
        {
          ((URLDrawable)localObject1).setTag(bavi.a(bbkx.a(40.0F), bbkx.a(40.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(bavi.o);
          if (localURLDrawable != null)
          {
            this.jdField_e_of_type_Int = paramAlumBasicData.jdField_a_of_type_Int;
            this.f = paramAlumBasicData.jdField_b_of_type_Int;
            int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - bbkx.b(56.0F);
            paramInt = i;
            if (this.jdField_e_of_type_Int != 0)
            {
              paramInt = i;
              if (this.f != 0) {
                paramInt = (int)(this.f / (this.jdField_e_of_type_Int * 1.0D) * j);
              }
            }
            if (paramInt != 0)
            {
              localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = paramInt;
              this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              QZLog.i("VipGeneralGdtShowView", " @getGdtInfo height  =" + paramInt + "contrlwith =" + j + "imagewith =" + this.jdField_e_of_type_Int + "imageheight =" + this.f);
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
            if (paramAlumBasicData.jdField_d_of_type_Int == 0)
            {
              paramAlumBasicData.jdField_d_of_type_Int = 1;
              a(paramAlumBasicData.e);
              a(1, paramAlumBasicData.jdField_a_of_type_JavaLangString, 0);
            }
          }
          if (localObject1 != null) {
            this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.h);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.i);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.c);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if (!QZLog.isColorLevel()) {
            break;
          }
          QZLog.i("VipGeneralGdtShowView", "setDataChanged titile =" + paramAlumBasicData.c + " desc =" + paramAlumBasicData.jdField_d_of_type_JavaLangString + " url =" + paramAlumBasicData.jdField_b_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception paramAlumBasicData)
      {
        QZLog.e("VipGeneralGdtShowView", paramAlumBasicData.toString());
        return;
      }
      ((URLDrawable)localObject1).setTag(bavi.b(bbkx.a(40.0F), bbkx.a(40.0F), bbkx.a(3.5F)));
      ((URLDrawable)localObject1).setDecodeHandler(bavi.i);
    }
  }
  
  public void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new VipGeneralGdtShowView.2(this, paramString), 0L);
  }
  
  public void a(WeakReference<Activity> paramWeakReference, int paramInt, Class<? extends GdtCanvasBaseFragment> paramClass)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = paramInt;
    if (paramWeakReference != null)
    {
      localParams.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_CooperationVipJsoninflateModelAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      localParams.jdField_b_of_type_JavaLangClass = paramClass;
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
      if (this.jdField_c_of_type_Int == 3) {
        localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_jc_kuolie");
      }
      GdtHandler.a(localParams);
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo clickAdvInfoToQiQiaoBan");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biay
 * JD-Core Version:    0.7.0.1
 */