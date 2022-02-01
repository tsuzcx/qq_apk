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

public class bfdt
  extends RecyclerView.Adapter<bfdp>
{
  public bfdt(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public bfdp a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560558, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new bfdu(this));
      paramViewGroup = new bfdx(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364873));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373883));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373881));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367955));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131381172));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367959));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365409));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131373066));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367033));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367019));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367039));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131367037));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131367038));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367024));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367023));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367022));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367025));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367035));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367028));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367030));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131367026));
      paramViewGroup.i.setImageResource(2130843560);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131367029));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131379308));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361876));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367951));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367950));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367948));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367953));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367954));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bhgr.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new bfdr(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new bfdv(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560557, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new bfdw(this));
        localObject = new bfdo(this.a, paramViewGroup);
        ((bfdo)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364873));
        ((bfdo)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373883));
        ((bfdo)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373881));
        ((bfdo)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367443));
        ((bfdo)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367451));
        ((bfdo)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367452));
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131373066));
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367410));
        ((bfdo)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131362028);
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367440));
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362030));
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131362032));
        ((bfdo)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bfdo)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bfdo)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((bfdo)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new bfdq(paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(bfdp parambfdp, int paramInt)
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
      localObject1 = (bfdx)parambfdp;
      localObject2 = (bfeg)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((bfdx)localObject1).jdField_a_of_type_Bfeg = ((bfeg)localObject2);
      ((bfdx)localObject1).jdField_a_of_type_Int = paramInt;
      this.a.j();
      if (!TextUtils.isEmpty(((bfeg)localObject2).jdField_b_of_type_JavaLangString))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
        ((bfdx)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bfeg)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
        if (((bfeg)localObject2).jdField_b_of_type_Int / ((bfeg)localObject2).jdField_a_of_type_Int > 0.75F)
        {
          ((bfdx)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((bfdx)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject3 = URLDrawable.getDrawable(((bfeg)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bhez.u);
          ((bfdx)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (((bfeg)localObject2).jdField_a_of_type_AndroidTextSpannable == null) {
            ((bfeg)localObject2).jdField_a_of_type_AndroidTextSpannable = this.a.a((bfeg)localObject2);
          }
          ((bfdx)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(((bfeg)localObject2).jdField_a_of_type_AndroidTextSpannable);
          ((bfdx)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((bfeg)localObject2).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((bfeg)localObject2).jdField_l_of_type_JavaLangString)) {
            break label569;
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = bhmq.b();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          localObject3 = URLDrawable.getDrawable(((bfeg)localObject2).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(bhez.a);
          ((bfdx)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (!((bfeg)localObject2).d) {
            break label583;
          }
          ((bfdx)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843567);
          ((bfdx)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((((bfeg)localObject2).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((bfeg)localObject2).jdField_c_of_type_Boolean)) {
            break label607;
          }
          ((bfdx)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label392:
          ((bfdx)localObject1).jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((bfeg)localObject2).jdField_l_of_type_Int));
          ((bfdx)localObject1).jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject3 = ((bfdx)localObject1).i;
          if (((bfeg)localObject2).jdField_k_of_type_Int == 0) {
            break label643;
          }
          i = 2130843561;
          label440:
          ((ImageView)localObject3).setImageResource(i);
          ((bfdx)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((bfeg)localObject2).m));
          ((bfdx)localObject1).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((bfdr)((bfdx)localObject1).jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((bfeg)localObject2).jdField_a_of_type_JavaUtilArrayList, (bfeg)localObject2);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambfdp, paramInt, getItemId(paramInt));
      return;
      ((bfdx)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((bfdx)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      ((bfdx)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      label569:
      ((bfdx)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bhmq.b());
      break label328;
      label583:
      ((bfdx)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843566);
      ((bfdx)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label356;
      label607:
      ((bfdx)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((bfdx)localObject1).l.clearAnimation();
      ((bfdx)localObject1).k.clearAnimation();
      ((bfdx)localObject1).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label392;
      label643:
      i = 2130843560;
      break label440;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (bfef)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject2 = (bfdo)parambfdp;
        this.a.j();
        ((bfdo)localObject2).jdField_a_of_type_Bfef = ((bfef)localObject1);
        ((bfdo)localObject2).jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((bfef)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((bfdo)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bfef)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
          if (((bfef)localObject1).jdField_a_of_type_Boolean)
          {
            ((bfdo)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((bfdo)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject3 = URLDrawable.getDrawable(((bfef)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bhez.u);
            ((bfdo)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label853:
            ((bfdo)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(((bfef)localObject1).d);
            if (TextUtils.isEmpty(((bfef)localObject1).e)) {
              break label1078;
            }
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = bhmq.b();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            localObject3 = URLDrawable.getDrawable(((bfef)localObject1).e, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(bhez.a);
            ((bfdo)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label931:
            ((bfdo)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(((bfef)localObject1).f);
            ((bfdo)localObject2).jdField_a_of_type_AndroidViewView.clearAnimation();
            ((bfdo)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((bfef)localObject1).jdField_a_of_type_Int != 12) {
              break label1103;
            }
            localObject2 = ((bfdo)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((bfef)localObject1).g)) {
              break label1092;
            }
          }
        }
        label1078:
        label1092:
        for (localObject1 = anzj.a(2131713885);; localObject1 = anzj.a(2131713896))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
          ((bfdo)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((bfdo)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break label853;
          ((bfdo)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break label853;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break label853;
          ((bfdo)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bhmq.b());
          break label931;
        }
        label1103:
        ((bfdo)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713884));
      }
      else if (getItemViewType(paramInt) == 2)
      {
        ((bfdq)parambfdp).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Bfdt.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof bfeg)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdt
 * JD-Core Version:    0.7.0.1
 */