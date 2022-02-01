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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class beeu
  extends RecyclerView.Adapter<beeq>
{
  public beeu(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public beeq a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560543, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new beev(this));
      paramViewGroup = new beey(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364826));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373764));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373762));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367885));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131380992));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367889));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365365));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131372953));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366982));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366968));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366988));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131366986));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131366987));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366973));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366972));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366971));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366974));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366984));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366977));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366979));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131366975));
      paramViewGroup.i.setImageResource(2130843542);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131366978));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131379144));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361876));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367881));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367880));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367878));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367883));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367884));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bggq.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new bees(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new beew(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560542, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new beex(this));
        localObject = new beep(this.a, paramViewGroup);
        ((beep)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364826));
        ((beep)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373764));
        ((beep)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373762));
        ((beep)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367384));
        ((beep)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367389));
        ((beep)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367390));
        ((beep)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131372953));
        ((beep)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367351));
        ((beep)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131362023);
        ((beep)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367381));
        ((beep)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362025));
        ((beep)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131362027));
        ((beep)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((beep)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((beep)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((beep)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((beep)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((beep)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new beer(paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(beeq parambeeq, int paramInt)
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
      localObject1 = (beey)parambeeq;
      localObject2 = (befh)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((beey)localObject1).jdField_a_of_type_Befh = ((befh)localObject2);
      ((beey)localObject1).jdField_a_of_type_Int = paramInt;
      this.a.j();
      if (!TextUtils.isEmpty(((befh)localObject2).jdField_b_of_type_JavaLangString))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
        ((beey)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((befh)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
        if (((befh)localObject2).jdField_b_of_type_Int / ((befh)localObject2).jdField_a_of_type_Int > 0.75F)
        {
          ((beey)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((beey)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject3 = URLDrawable.getDrawable(((befh)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bgey.u);
          ((beey)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (((befh)localObject2).jdField_a_of_type_AndroidTextSpannable == null) {
            ((befh)localObject2).jdField_a_of_type_AndroidTextSpannable = this.a.a((befh)localObject2);
          }
          ((beey)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(((befh)localObject2).jdField_a_of_type_AndroidTextSpannable);
          ((beey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((befh)localObject2).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((befh)localObject2).jdField_l_of_type_JavaLangString)) {
            break label569;
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = bgmo.b();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          localObject3 = URLDrawable.getDrawable(((befh)localObject2).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bgey.a);
          ((beey)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (!((befh)localObject2).d) {
            break label583;
          }
          ((beey)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843549);
          ((beey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((((befh)localObject2).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((befh)localObject2).jdField_c_of_type_Boolean)) {
            break label607;
          }
          ((beey)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label392:
          ((beey)localObject1).jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((befh)localObject2).jdField_l_of_type_Int));
          ((beey)localObject1).jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject3 = ((beey)localObject1).i;
          if (((befh)localObject2).jdField_k_of_type_Int == 0) {
            break label643;
          }
          i = 2130843543;
          label440:
          ((ImageView)localObject3).setImageResource(i);
          ((beey)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((befh)localObject2).m));
          ((beey)localObject1).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((bees)((beey)localObject1).jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((befh)localObject2).jdField_a_of_type_JavaUtilArrayList, (befh)localObject2);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambeeq, paramInt, getItemId(paramInt));
      return;
      ((beey)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((beey)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      ((beey)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      label569:
      ((beey)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bgmo.b());
      break label328;
      label583:
      ((beey)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843548);
      ((beey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label356;
      label607:
      ((beey)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((beey)localObject1).l.clearAnimation();
      ((beey)localObject1).k.clearAnimation();
      ((beey)localObject1).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label392;
      label643:
      i = 2130843542;
      break label440;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (befg)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject2 = (beep)parambeeq;
        this.a.j();
        ((beep)localObject2).jdField_a_of_type_Befg = ((befg)localObject1);
        ((beep)localObject2).jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((befg)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((beep)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((befg)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
          if (((befg)localObject1).jdField_a_of_type_Boolean)
          {
            ((beep)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((beep)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject3 = URLDrawable.getDrawable(((befg)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bgey.u);
            ((beep)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label853:
            ((beep)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(((befg)localObject1).d);
            if (TextUtils.isEmpty(((befg)localObject1).e)) {
              break label1078;
            }
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = bgmo.b();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            localObject3 = URLDrawable.getDrawable(((befg)localObject1).e, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bgey.a);
            ((beep)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label931:
            ((beep)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(((befg)localObject1).f);
            ((beep)localObject2).jdField_a_of_type_AndroidViewView.clearAnimation();
            ((beep)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((befg)localObject1).jdField_a_of_type_Int != 12) {
              break label1103;
            }
            localObject2 = ((beep)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((befg)localObject1).g)) {
              break label1092;
            }
          }
        }
        label1078:
        label1092:
        for (localObject1 = anni.a(2131713776);; localObject1 = anni.a(2131713787))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
          ((beep)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((beep)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break label853;
          ((beep)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break label853;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break label853;
          ((beep)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bgmo.b());
          break label931;
        }
        label1103:
        ((beep)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131713775));
      }
      else if (getItemViewType(paramInt) == 2)
      {
        ((beer)parambeeq).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Beeu.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof befh)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeu
 * JD-Core Version:    0.7.0.1
 */