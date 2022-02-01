import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class bdmh
  extends RecyclerView.Adapter<bdmd>
{
  public bdmh(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public bdmd a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560568, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new bdmi(this));
      paramViewGroup = new bdml(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364900));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373805));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373803));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367988));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131380891));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367992));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365441));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131373036));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367047));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367033));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367056));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131367054));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131367055));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367038));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367037));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367036));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367039));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367049));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367042));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367044));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131367040));
      paramViewGroup.i.setImageResource(2130843622);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131367043));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131379078));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361876));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367984));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367983));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367981));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367986));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367987));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(DisplayUtil.dip2px(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new bdmf(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new bdmj(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560567, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new bdmk(this));
        localObject = new bdmc(this.a, paramViewGroup);
        ((bdmc)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364900));
        ((bdmc)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373805));
        ((bdmc)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373803));
        ((bdmc)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367471));
        ((bdmc)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367479));
        ((bdmc)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367480));
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131373036));
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367438));
        ((bdmc)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131362027);
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367468));
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362029));
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131362031));
        ((bdmc)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bdmc)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bdmc)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((bdmc)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new bdme(paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(bdmd parambdmd, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label328:
    label356:
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      localObject1 = (bdml)parambdmd;
      localObject2 = (bdmu)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((bdml)localObject1).jdField_a_of_type_Bdmu = ((bdmu)localObject2);
      ((bdml)localObject1).jdField_a_of_type_Int = paramInt;
      this.a.j();
      if (!TextUtils.isEmpty(((bdmu)localObject2).jdField_b_of_type_JavaLangString))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
        ((bdml)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bdmu)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
        if (((bdmu)localObject2).jdField_b_of_type_Int / ((bdmu)localObject2).jdField_a_of_type_Int > 0.75F)
        {
          ((bdml)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((bdml)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject3 = URLDrawable.getDrawable(((bdmu)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bfol.u);
          ((bdml)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (((bdmu)localObject2).jdField_a_of_type_AndroidTextSpannable == null) {
            ((bdmu)localObject2).jdField_a_of_type_AndroidTextSpannable = this.a.a((bdmu)localObject2);
          }
          ((bdml)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(((bdmu)localObject2).jdField_a_of_type_AndroidTextSpannable);
          ((bdml)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((bdmu)localObject2).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((bdmu)localObject2).jdField_l_of_type_JavaLangString)) {
            break label569;
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = bfvo.b();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          localObject3 = URLDrawable.getDrawable(((bdmu)localObject2).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bfol.a);
          ((bdml)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (!((bdmu)localObject2).d) {
            break label583;
          }
          ((bdml)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843629);
          ((bdml)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((((bdmu)localObject2).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((bdmu)localObject2).jdField_c_of_type_Boolean)) {
            break label607;
          }
          ((bdml)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label392:
          ((bdml)localObject1).jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((bdmu)localObject2).jdField_l_of_type_Int));
          ((bdml)localObject1).jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject3 = ((bdml)localObject1).i;
          if (((bdmu)localObject2).jdField_k_of_type_Int == 0) {
            break label643;
          }
          i = 2130843623;
          label440:
          ((ImageView)localObject3).setImageResource(i);
          ((bdml)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((bdmu)localObject2).m));
          ((bdml)localObject1).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((bdmf)((bdml)localObject1).jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((bdmu)localObject2).jdField_a_of_type_JavaUtilArrayList, (bdmu)localObject2);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambdmd, paramInt, getItemId(paramInt));
      return;
      ((bdml)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((bdml)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      ((bdml)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      label569:
      ((bdml)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bfvo.b());
      break label328;
      label583:
      ((bdml)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843628);
      ((bdml)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label356;
      label607:
      ((bdml)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((bdml)localObject1).l.clearAnimation();
      ((bdml)localObject1).k.clearAnimation();
      ((bdml)localObject1).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label392;
      label643:
      i = 2130843622;
      break label440;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (bdmt)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject2 = (bdmc)parambdmd;
        this.a.j();
        ((bdmc)localObject2).jdField_a_of_type_Bdmt = ((bdmt)localObject1);
        ((bdmc)localObject2).jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((bdmt)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((bdmc)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bdmt)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
          if (((bdmt)localObject1).jdField_a_of_type_Boolean)
          {
            ((bdmc)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((bdmc)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject3 = URLDrawable.getDrawable(((bdmt)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bfol.u);
            ((bdmc)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label853:
            ((bdmc)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(((bdmt)localObject1).d);
            if (TextUtils.isEmpty(((bdmt)localObject1).e)) {
              break label1078;
            }
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = bfvo.b();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            localObject3 = URLDrawable.getDrawable(((bdmt)localObject1).e, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bfol.a);
            ((bdmc)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label931:
            ((bdmc)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(((bdmt)localObject1).f);
            ((bdmc)localObject2).jdField_a_of_type_AndroidViewView.clearAnimation();
            ((bdmc)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((bdmt)localObject1).jdField_a_of_type_Int != 12) {
              break label1103;
            }
            localObject2 = ((bdmc)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((bdmt)localObject1).g)) {
              break label1092;
            }
          }
        }
        label1078:
        label1092:
        for (localObject1 = amtj.a(2131714117);; localObject1 = amtj.a(2131714128))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
          ((bdmc)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((bdmc)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break label853;
          ((bdmc)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break label853;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break label853;
          ((bdmc)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bfvo.b());
          break label931;
        }
        label1103:
        ((bdmc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131714116));
      }
      else if (getItemViewType(paramInt) == 2)
      {
        ((bdme)parambdmd).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Bdmh.getItemCount() - 1);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof bdmu)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmh
 * JD-Core Version:    0.7.0.1
 */