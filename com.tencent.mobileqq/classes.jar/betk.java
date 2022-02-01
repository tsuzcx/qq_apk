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

public class betk
  extends RecyclerView.Adapter<betg>
{
  public betk(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public betg a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560620, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new betl(this));
      paramViewGroup = new beto(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364988));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374023));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374021));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368124));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131381243));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131368128));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365534));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131373246));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367166));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367151));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367175));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131367173));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131367174));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367157));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367156));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367155));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367158));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367168));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367161));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367163));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131367159));
      paramViewGroup.i.setImageResource(2130843659);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131367162));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131379374));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361878));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131368120));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131368119));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131368117));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131368122));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131368123));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(DisplayUtil.dip2px(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new beti(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new betm(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560619, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new betn(this));
        localObject = new betf(this.a, paramViewGroup);
        ((betf)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364988));
        ((betf)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374023));
        ((betf)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374021));
        ((betf)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367603));
        ((betf)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367611));
        ((betf)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367612));
        ((betf)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131373246));
        ((betf)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367569));
        ((betf)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131362032);
        ((betf)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367600));
        ((betf)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362034));
        ((betf)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131362036));
        ((betf)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((betf)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((betf)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((betf)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((betf)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((betf)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new beth(paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(betg parambetg, int paramInt)
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
      localObject1 = (beto)parambetg;
      localObject2 = (betx)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((beto)localObject1).jdField_a_of_type_Betx = ((betx)localObject2);
      ((beto)localObject1).jdField_a_of_type_Int = paramInt;
      this.a.j();
      if (!TextUtils.isEmpty(((betx)localObject2).jdField_b_of_type_JavaLangString))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
        ((beto)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((betx)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
        if (((betx)localObject2).jdField_b_of_type_Int / ((betx)localObject2).jdField_a_of_type_Int > 0.75F)
        {
          ((beto)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((beto)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject3 = URLDrawable.getDrawable(((betx)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bgxc.u);
          ((beto)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (((betx)localObject2).jdField_a_of_type_AndroidTextSpannable == null) {
            ((betx)localObject2).jdField_a_of_type_AndroidTextSpannable = this.a.a((betx)localObject2);
          }
          ((beto)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(((betx)localObject2).jdField_a_of_type_AndroidTextSpannable);
          ((beto)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((betx)localObject2).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((betx)localObject2).jdField_l_of_type_JavaLangString)) {
            break label569;
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = bheg.b();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          localObject3 = URLDrawable.getDrawable(((betx)localObject2).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bgxc.a);
          ((beto)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (!((betx)localObject2).d) {
            break label583;
          }
          ((beto)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843666);
          ((beto)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((((betx)localObject2).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((betx)localObject2).jdField_c_of_type_Boolean)) {
            break label607;
          }
          ((beto)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label392:
          ((beto)localObject1).jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((betx)localObject2).jdField_l_of_type_Int));
          ((beto)localObject1).jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject3 = ((beto)localObject1).i;
          if (((betx)localObject2).jdField_k_of_type_Int == 0) {
            break label643;
          }
          i = 2130843660;
          label440:
          ((ImageView)localObject3).setImageResource(i);
          ((beto)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((betx)localObject2).m));
          ((beto)localObject1).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((beti)((beto)localObject1).jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((betx)localObject2).jdField_a_of_type_JavaUtilArrayList, (betx)localObject2);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambetg, paramInt, getItemId(paramInt));
      return;
      ((beto)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((beto)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      ((beto)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      label569:
      ((beto)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bheg.b());
      break label328;
      label583:
      ((beto)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843665);
      ((beto)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label356;
      label607:
      ((beto)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((beto)localObject1).l.clearAnimation();
      ((beto)localObject1).k.clearAnimation();
      ((beto)localObject1).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label392;
      label643:
      i = 2130843659;
      break label440;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (betw)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject2 = (betf)parambetg;
        this.a.j();
        ((betf)localObject2).jdField_a_of_type_Betw = ((betw)localObject1);
        ((betf)localObject2).jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((betw)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((betf)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((betw)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
          if (((betw)localObject1).jdField_a_of_type_Boolean)
          {
            ((betf)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((betf)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject3 = URLDrawable.getDrawable(((betw)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bgxc.u);
            ((betf)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label853:
            ((betf)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(((betw)localObject1).d);
            if (TextUtils.isEmpty(((betw)localObject1).e)) {
              break label1078;
            }
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = bheg.b();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            localObject3 = URLDrawable.getDrawable(((betw)localObject1).e, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bgxc.a);
            ((betf)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label931:
            ((betf)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(((betw)localObject1).f);
            ((betf)localObject2).jdField_a_of_type_AndroidViewView.clearAnimation();
            ((betf)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((betw)localObject1).jdField_a_of_type_Int != 12) {
              break label1103;
            }
            localObject2 = ((betf)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((betw)localObject1).g)) {
              break label1092;
            }
          }
        }
        label1078:
        label1092:
        for (localObject1 = anvx.a(2131714464);; localObject1 = anvx.a(2131714475))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
          ((betf)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((betf)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break label853;
          ((betf)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break label853;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break label853;
          ((betf)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bheg.b());
          break label931;
        }
        label1103:
        ((betf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131714463));
      }
      else if (getItemViewType(paramInt) == 2)
      {
        ((beth)parambetg).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Betk.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof betx)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betk
 * JD-Core Version:    0.7.0.1
 */