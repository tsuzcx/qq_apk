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
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class axoj
{
  protected float a;
  protected int a;
  protected Drawable a;
  protected GradientDrawable a;
  public Handler a;
  protected View.OnClickListener a;
  protected LinearLayout a;
  protected axon a;
  Runnable a;
  protected ArrayList<axom> a;
  public List<ilive_feeds_near_anchor.NearAnchorInfo> a;
  public int b;
  
  public axoj(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new NearbyFragmentEnterAdapter.1(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new axol(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_Float = ((float)(DeviceInfoUtil.getPortraitWidth() * 2L / 9L));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float - DisplayUtil.dip2px(paramContext, 20.0F)));
    int i = DisplayUtil.dip2px(paramContext, 80.0F);
    if (this.jdField_a_of_type_Int > i) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840350);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor("#FFDDDFE2"));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public View a(Context paramContext, int paramInt)
  {
    axom localaxom = (axom)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    View localView = LayoutInflater.from(paramContext).inflate(2131559535, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    axoo localaxoo = new axoo();
    localaxoo.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368381));
    localaxoo.b = ((URLImageView)localView.findViewById(2131368382));
    localaxoo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380283));
    localaxoo.c = ((URLImageView)localView.findViewById(2131368406));
    localaxoo.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380327));
    localaxoo.jdField_a_of_type_Int = paramInt;
    localView.setTag(localaxoo);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    Object localObject = (RelativeLayout.LayoutParams)localaxoo.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)this.jdField_a_of_type_Float);
    localaxoo.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localaxoo.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    localaxoo.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localaxoo.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    localaxoo.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localaxoo.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localaxoo.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = (View)localaxoo.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)this.jdField_a_of_type_Float);
    ((View)localObject).setLayoutParams(localLayoutParams);
    localView.setTag(2131378439, Integer.valueOf(localaxom.jdField_a_of_type_Int));
    if (localaxom.jdField_b_of_type_Int != 0)
    {
      localaxoo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, localaxoo.jdField_a_of_type_ComTencentImageURLImageView);
      localaxoo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b(53).a();
      localView.setTag(2131376435, Integer.valueOf(localaxom.jdField_b_of_type_Int));
    }
    if (localaxom.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        a(localaxoo, (ilive_feeds_near_anchor.NearAnchorInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
        localaxoo.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#05d380"));
        localaxoo.c.setVisibility(0);
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        paramContext.mPlayGifImage = true;
        paramContext = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif", paramContext);
        localaxoo.c.setImageDrawable(paramContext);
        localaxoo.c.setAdjustViewBounds(true);
        localaxoo.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localaxoo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      localaxoo.jdField_a_of_type_AndroidWidgetTextView.setText(localaxom.c);
      return localView;
      a(localaxoo.b, localaxom.jdField_b_of_type_JavaLangString);
      break;
      localaxoo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localaxoo.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      localaxoo.c.setVisibility(8);
      a(localaxoo.jdField_a_of_type_ComTencentImageURLImageView, localaxom.jdField_b_of_type_JavaLangString);
    }
  }
  
  public axoo a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView != null) && (((Integer)localView.getTag(2131378439)).intValue() == 1)) {
        return (axoo)localView.getTag();
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
          localURLDrawable = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        localURLDrawable.setTag(bgxc.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localURLDrawable.setDecodeHandler(bgxc.a);
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
  
  public void a(axon paramaxon)
  {
    this.jdField_a_of_type_Axon = paramaxon;
  }
  
  @RequiresApi(api=11)
  public void a(axoo paramaxoo, ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_fragment_live_avatar";
    paramNearAnchorInfo = URLDrawable.getDrawable(paramNearAnchorInfo.cover_url.get().toStringUtf8(), (URLDrawable.URLDrawableOptions)localObject);
    paramNearAnchorInfo.setTag(bgxc.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
    paramNearAnchorInfo.setDecodeHandler(bgxc.a);
    if (this.jdField_a_of_type_JavaUtilList.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(paramaxoo.b, "alpha", new float[] { 1.0F, 0.2F });
      ((ObjectAnimator)localObject).setInterpolator(new AccelerateInterpolator());
      ((ObjectAnimator)localObject).addListener(new axok(this, paramaxoo, paramNearAnchorInfo));
      ((ObjectAnimator)localObject).setDuration(300L).start();
      return;
    }
    paramaxoo.b.setImageDrawable(paramNearAnchorInfo);
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface)
  {
    axut localaxut = paramNearbyAppInterface.a();
    if (localaxut == null) {
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
        axoo localaxoo = (axoo)((View)localObject2).getTag();
        Object localObject1 = (Integer)((View)localObject2).getTag(2131376435);
        localObject2 = (Integer)((View)localObject2).getTag(2131378439);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = localaxut.a(((Integer)localObject1).intValue());
          bool1 = localaxoo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c();
          localaxoo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          bool2 = localaxoo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c();
          if ((!bool1) || (bool2)) {
            break label161;
          }
          axql.a(paramNearbyAppInterface, "op_red_clear", ((Integer)localObject2).intValue());
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
        axql.a(paramNearbyAppInterface, "op_red_push", ((Integer)localObject2).intValue());
      }
    }
  }
  
  public void a(List<axom> paramList)
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
      paramList = a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), i);
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
 * Qualified Name:     axoj
 * JD-Core Version:    0.7.0.1
 */