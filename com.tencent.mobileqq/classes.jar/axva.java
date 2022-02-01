import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class axva
{
  protected float a;
  protected int a;
  protected Context a;
  protected Drawable a;
  protected GradientDrawable a;
  public Handler a;
  protected View.OnClickListener a;
  protected AdapterView.OnItemClickListener a;
  protected LinearLayout a;
  Runnable a;
  protected ArrayList<axvd> a;
  public List<ilive_feeds_near_anchor.NearAnchorInfo> a;
  public int b;
  
  public axva(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new NearbyFragmentEnterAdapter.1(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new axvc(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = ((float)(bhlo.i() * 2L / 9L));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 20.0F)));
    int i = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 80.0F);
    if (this.jdField_a_of_type_Int > i) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840276);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor("#FFDDDFE2"));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public View a(int paramInt)
  {
    axvd localaxvd = (axvd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559500, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    axve localaxve = new axve();
    localaxve.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368212));
    localaxve.b = ((URLImageView)localView.findViewById(2131368213));
    localaxve.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380216));
    localaxve.c = ((URLImageView)localView.findViewById(2131368237));
    localaxve.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380261));
    localaxve.jdField_a_of_type_Int = paramInt;
    localView.setTag(localaxve);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    Object localObject = (RelativeLayout.LayoutParams)localaxve.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)this.jdField_a_of_type_Float);
    localaxve.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localaxve.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    localaxve.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localaxve.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    localaxve.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localaxve.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localaxve.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = (View)localaxve.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)this.jdField_a_of_type_Float);
    ((View)localObject).setLayoutParams(localLayoutParams);
    localView.setTag(2131378384, Integer.valueOf(localaxvd.jdField_a_of_type_Int));
    if (localaxvd.jdField_b_of_type_Int != 0)
    {
      localaxve.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localaxve.jdField_a_of_type_ComTencentImageURLImageView);
      localaxve.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a();
      localView.setTag(2131376418, Integer.valueOf(localaxvd.jdField_b_of_type_Int));
    }
    if (localaxvd.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        a(localaxve, (ilive_feeds_near_anchor.NearAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
        localaxve.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#05d380"));
        localaxve.c.setVisibility(0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif", (URLDrawable.URLDrawableOptions)localObject);
        localaxve.c.setImageDrawable((Drawable)localObject);
        localaxve.c.setAdjustViewBounds(true);
        localaxve.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localaxve.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      localaxve.jdField_a_of_type_AndroidWidgetTextView.setText(localaxvd.c);
      return localView;
      a(localaxve.b, localaxvd.jdField_b_of_type_JavaLangString);
      break;
      localaxve.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localaxve.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      localaxve.c.setVisibility(8);
      a(localaxve.jdField_a_of_type_ComTencentImageURLImageView, localaxvd.jdField_b_of_type_JavaLangString);
    }
  }
  
  public axve a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView != null) && (((Integer)localView.getTag(2131378384)).intValue() == 1)) {
        return (axve)localView.getTag();
      }
      i += 1;
    }
    return null;
  }
  
  public ilive_feeds_near_anchor.NearAnchorInfo a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (ilive_feeds_near_anchor.NearAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    URLDrawable localURLDrawable = null;
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "nearby_fragment_enter_icon";
        if (!TextUtils.isEmpty(paramString)) {
          localURLDrawable = URLDrawable.getDrawable(bevg.a(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        localURLDrawable.setTag(bhez.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localURLDrawable.setDecodeHandler(bhez.a);
        if (localURLDrawable.getStatus() != 2)
        {
          localObject1 = localURLDrawable;
          if (localURLDrawable.getStatus() != 3) {}
        }
        else
        {
          localURLDrawable.restartDownload();
          localObject1 = localURLDrawable;
          if (QLog.isColorLevel())
          {
            QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage restartDownload");
            localObject1 = localURLDrawable;
          }
        }
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject2 = localException2;
        }
      }
      localObject1 = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage empty url");
        localObject1 = localURLDrawable;
        continue;
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
        if (QLog.isColorLevel()) {
          QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage exp: url=" + paramString + ", " + localException1.toString());
        }
      }
    }
  }
  
  @RequiresApi(api=11)
  public void a(axve paramaxve, ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_fragment_live_avatar";
    paramNearAnchorInfo = URLDrawable.getDrawable(paramNearAnchorInfo.cover_url.get().toStringUtf8(), (URLDrawable.URLDrawableOptions)localObject);
    paramNearAnchorInfo.setTag(bhez.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
    paramNearAnchorInfo.setDecodeHandler(bhez.a);
    if (this.jdField_a_of_type_JavaUtilList.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(paramaxve.b, "alpha", new float[] { 1.0F, 0.2F });
      ((ObjectAnimator)localObject).setInterpolator(new AccelerateInterpolator());
      ((ObjectAnimator)localObject).addListener(new axvb(this, paramaxve, paramNearAnchorInfo));
      ((ObjectAnimator)localObject).setDuration(300L).start();
      return;
    }
    paramaxve.b.setImageDrawable(paramNearAnchorInfo);
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface)
  {
    aybj localaybj = paramNearbyAppInterface.a();
    if (localaybj == null) {
      return;
    }
    int i = 0;
    label14:
    Object localObject2;
    boolean bool1;
    boolean bool2;
    if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject2 != null) && (((View)localObject2).getTag() != null))
      {
        axve localaxve = (axve)((View)localObject2).getTag();
        Object localObject1 = (Integer)((View)localObject2).getTag(2131376418);
        localObject2 = (Integer)((View)localObject2).getTag(2131378384);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = localaybj.a(((Integer)localObject1).intValue());
          bool1 = localaxve.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          localaxve.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          bool2 = localaxve.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          if ((!bool1) || (bool2)) {
            break label161;
          }
          axxb.a(paramNearbyAppInterface, "op_red_clear", ((Integer)localObject2).intValue());
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      break;
      label161:
      if ((!bool1) && (bool2)) {
        axxb.a(paramNearbyAppInterface, "op_red_push", ((Integer)localObject2).intValue());
      }
    }
  }
  
  public void a(List<axvd> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramList = a(i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
      i += 1;
    }
  }
  
  public void b(List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axva
 * JD-Core Version:    0.7.0.1
 */