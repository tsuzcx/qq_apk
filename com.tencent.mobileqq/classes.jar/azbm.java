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
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class azbm
  extends RecyclerView.Adapter<azbh>
{
  public azbm(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public azbh a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560281, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new azbn(this));
      paramViewGroup = new azbq(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364534));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131372754));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131372752));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367435));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131379267));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367438));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365039));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131372022));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366597));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366580));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366603));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131366601));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131366602));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366586));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366585));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366584));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366587));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366599));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366590));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366592));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131366588));
      paramViewGroup.i.setImageResource(2130842983);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131366591));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131377693));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361843));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367431));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367430));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367428));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367433));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367434));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bawz.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new azbk(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new azbo(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560280, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new azbp(this));
        localObject = new azbg(this.a, paramViewGroup);
        ((azbg)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364534));
        ((azbg)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372754));
        ((azbg)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372752));
        ((azbg)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366960));
        ((azbg)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366965));
        ((azbg)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366967));
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131372022));
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366943));
        ((azbg)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131361965);
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131366958));
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131361966));
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131361968));
        ((azbg)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((azbg)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((azbg)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new azbi(this.a, paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(azbh paramazbh, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 0)
    {
      paramazbh = (azbq)paramazbh;
      localObject1 = (azbz)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramazbh.jdField_a_of_type_Azbz = ((azbz)localObject1);
      paramazbh.jdField_a_of_type_Int = paramInt;
      this.a.k();
      if (!TextUtils.isEmpty(((azbz)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
        paramazbh.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((azbz)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
        if (((azbz)localObject1).jdField_b_of_type_Int / ((azbz)localObject1).jdField_a_of_type_Int > 0.75F)
        {
          paramazbh.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramazbh.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject2 = URLDrawable.getDrawable(((azbz)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bavi.t);
          paramazbh.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if (((azbz)localObject1).jdField_a_of_type_AndroidTextSpannable == null) {
            ((azbz)localObject1).jdField_a_of_type_AndroidTextSpannable = this.a.a((azbz)localObject1);
          }
          paramazbh.jdField_c_of_type_AndroidWidgetTextView.setText(((azbz)localObject1).jdField_a_of_type_AndroidTextSpannable);
          paramazbh.jdField_b_of_type_AndroidWidgetTextView.setText(((azbz)localObject1).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((azbz)localObject1).jdField_l_of_type_JavaLangString)) {
            break label512;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = bbdr.b();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          localObject2 = URLDrawable.getDrawable(((azbz)localObject1).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bavi.a);
          paramazbh.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label304:
          if (!((azbz)localObject1).d) {
            break label525;
          }
          paramazbh.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842990);
          paramazbh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          label329:
          if ((((azbz)localObject1).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((azbz)localObject1).jdField_c_of_type_Boolean)) {
            break label547;
          }
          paramazbh.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label362:
          paramazbh.jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((azbz)localObject1).jdField_l_of_type_Int));
          paramazbh.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject2 = paramazbh.i;
          if (((azbz)localObject1).jdField_k_of_type_Int == 0) {
            break label579;
          }
          paramInt = 2130842984;
          label405:
          ((ImageView)localObject2).setImageResource(paramInt);
          paramazbh.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((azbz)localObject1).m));
          paramazbh.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((azbk)paramazbh.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((azbz)localObject1).jdField_a_of_type_JavaUtilArrayList, (azbz)localObject1);
        }
      }
    }
    label512:
    label525:
    label547:
    label579:
    label849:
    label982:
    label995:
    label1005:
    do
    {
      return;
      paramazbh.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramazbh.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      paramazbh.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      paramazbh.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bbdr.b());
      break label304;
      paramazbh.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842989);
      paramazbh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label329;
      paramazbh.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramazbh.l.clearAnimation();
      paramazbh.k.clearAnimation();
      paramazbh.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label362;
      paramInt = 2130842983;
      break label405;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (azby)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramazbh = (azbg)paramazbh;
        this.a.k();
        paramazbh.jdField_a_of_type_Azby = ((azby)localObject1);
        paramazbh.jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((azby)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          paramazbh.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((azby)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
          if (((azby)localObject1).jdField_a_of_type_Boolean)
          {
            paramazbh.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramazbh.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject2 = URLDrawable.getDrawable(((azby)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bavi.t);
            paramazbh.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramazbh.jdField_b_of_type_AndroidWidgetTextView.setText(((azby)localObject1).d);
            if (TextUtils.isEmpty(((azby)localObject1).e)) {
              break label982;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = bbdr.b();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            localObject2 = URLDrawable.getDrawable(((azby)localObject1).e, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bavi.a);
            paramazbh.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramazbh.jdField_c_of_type_AndroidWidgetTextView.setText(((azby)localObject1).f);
            paramazbh.jdField_a_of_type_AndroidViewView.clearAnimation();
            paramazbh.jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((azby)localObject1).jdField_a_of_type_Int != 12) {
              break label1005;
            }
            localObject2 = paramazbh.jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((azby)localObject1).g)) {
              break label995;
            }
          }
        }
        for (paramazbh = ajyc.a(2131715100);; paramazbh = ajyc.a(2131715111))
        {
          ((TextView)localObject2).setText(paramazbh);
          return;
          paramazbh.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramazbh.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          paramazbh.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break;
          paramazbh.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bbdr.b());
          break label849;
        }
        paramazbh.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131715099));
        return;
      }
    } while (getItemViewType(paramInt) != 2);
    ((azbi)paramazbh).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Azbm.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof azbz)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbm
 * JD-Core Version:    0.7.0.1
 */