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

public class aybe
  extends RecyclerView.Adapter<ayaz>
{
  public aybe(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public ayaz a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131494709, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new aybf(this));
      paramViewGroup = new aybi(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131298974));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131307042));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131307040));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131301824));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131313433));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131301827));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131299471));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131306325));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131300986));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131300969));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131300992));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131300990));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131300991));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131300975));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131300974));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131300973));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131300976));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131300988));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131300979));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131300981));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131300977));
      paramViewGroup.i.setImageResource(2130842900);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131300980));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131311872));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131296307));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131301820));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131301819));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131301818));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131301822));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131301823));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(azvv.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new aybc(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new aybg(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494708, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new aybh(this));
        localObject = new ayay(this.a, paramViewGroup);
        ((ayay)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131298974));
        ((ayay)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131307042));
        ((ayay)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131307040));
        ((ayay)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131301351));
        ((ayay)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301356));
        ((ayay)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301358));
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131306325));
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131301334));
        ((ayay)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131296423);
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131301349));
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296424));
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131296426));
        ((ayay)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((ayay)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((ayay)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((ayay)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new ayba(this.a, paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(ayaz paramayaz, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 0)
    {
      paramayaz = (aybi)paramayaz;
      localObject1 = (aybq)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramayaz.jdField_a_of_type_Aybq = ((aybq)localObject1);
      paramayaz.jdField_a_of_type_Int = paramInt;
      this.a.k();
      if (!TextUtils.isEmpty(((aybq)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
        paramayaz.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((aybq)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
        if (((aybq)localObject1).jdField_b_of_type_Int / ((aybq)localObject1).jdField_a_of_type_Int > 0.75F)
        {
          paramayaz.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramayaz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject2 = URLDrawable.getDrawable(((aybq)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(azue.t);
          paramayaz.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if (((aybq)localObject1).jdField_a_of_type_AndroidTextSpannable == null) {
            ((aybq)localObject1).jdField_a_of_type_AndroidTextSpannable = this.a.a((aybq)localObject1);
          }
          paramayaz.jdField_c_of_type_AndroidWidgetTextView.setText(((aybq)localObject1).jdField_a_of_type_AndroidTextSpannable);
          paramayaz.jdField_b_of_type_AndroidWidgetTextView.setText(((aybq)localObject1).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((aybq)localObject1).jdField_l_of_type_JavaLangString)) {
            break label512;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = bacm.b();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          localObject2 = URLDrawable.getDrawable(((aybq)localObject1).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(azue.a);
          paramayaz.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label304:
          if (!((aybq)localObject1).d) {
            break label525;
          }
          paramayaz.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842907);
          paramayaz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          label329:
          if ((((aybq)localObject1).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((aybq)localObject1).jdField_c_of_type_Boolean)) {
            break label547;
          }
          paramayaz.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label362:
          paramayaz.jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((aybq)localObject1).jdField_l_of_type_Int));
          paramayaz.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject2 = paramayaz.i;
          if (((aybq)localObject1).jdField_k_of_type_Int == 0) {
            break label579;
          }
          paramInt = 2130842901;
          label405:
          ((ImageView)localObject2).setImageResource(paramInt);
          paramayaz.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((aybq)localObject1).m));
          paramayaz.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((aybc)paramayaz.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((aybq)localObject1).jdField_a_of_type_JavaUtilArrayList, (aybq)localObject1);
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
      paramayaz.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramayaz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      paramayaz.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      paramayaz.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bacm.b());
      break label304;
      paramayaz.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842906);
      paramayaz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label329;
      paramayaz.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramayaz.l.clearAnimation();
      paramayaz.k.clearAnimation();
      paramayaz.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label362;
      paramInt = 2130842900;
      break label405;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (aybp)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramayaz = (ayay)paramayaz;
        this.a.k();
        paramayaz.jdField_a_of_type_Aybp = ((aybp)localObject1);
        paramayaz.jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((aybp)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          paramayaz.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((aybp)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
          if (((aybp)localObject1).jdField_a_of_type_Boolean)
          {
            paramayaz.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramayaz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject2 = URLDrawable.getDrawable(((aybp)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(azue.t);
            paramayaz.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramayaz.jdField_b_of_type_AndroidWidgetTextView.setText(((aybp)localObject1).d);
            if (TextUtils.isEmpty(((aybp)localObject1).e)) {
              break label982;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = bacm.b();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            localObject2 = URLDrawable.getDrawable(((aybp)localObject1).e, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(azue.a);
            paramayaz.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramayaz.jdField_c_of_type_AndroidWidgetTextView.setText(((aybp)localObject1).f);
            paramayaz.jdField_a_of_type_AndroidViewView.clearAnimation();
            paramayaz.jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((aybp)localObject1).jdField_a_of_type_Int != 12) {
              break label1005;
            }
            localObject2 = paramayaz.jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((aybp)localObject1).g)) {
              break label995;
            }
          }
        }
        for (paramayaz = ajjy.a(2131649311);; paramayaz = ajjy.a(2131649322))
        {
          ((TextView)localObject2).setText(paramayaz);
          return;
          paramayaz.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramayaz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          paramayaz.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break;
          paramayaz.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bacm.b());
          break label849;
        }
        paramayaz.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649310));
        return;
      }
    } while (getItemViewType(paramInt) != 2);
    ((ayba)paramayaz).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Aybe.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof aybq)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybe
 * JD-Core Version:    0.7.0.1
 */