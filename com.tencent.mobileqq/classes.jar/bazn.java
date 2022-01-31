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

public class bazn
  extends RecyclerView.Adapter<bazi>
{
  public bazn(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public bazi a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560389, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new bazo(this));
      paramViewGroup = new bazr(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364607));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373112));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373110));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367563));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131379973));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367566));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365123));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131372339));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366711));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366696));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366717));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131366715));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131366716));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366701));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366700));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366699));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366702));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366713));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366705));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366707));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131366703));
      paramViewGroup.i.setImageResource(2130843168);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131366706));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131378234));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361842));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367559));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367558));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367556));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367561));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367562));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bcwh.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new bazl(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new bazp(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560388, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new bazq(this));
        localObject = new bazh(this.a, paramViewGroup);
        ((bazh)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364607));
        ((bazh)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373112));
        ((bazh)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373110));
        ((bazh)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367082));
        ((bazh)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367087));
        ((bazh)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367089));
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131372339));
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367064));
        ((bazh)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131361966);
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367079));
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131361967));
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131361969));
        ((bazh)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bazh)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bazh)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((bazh)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new bazj(this.a, paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(bazi parambazi, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 0)
    {
      parambazi = (bazr)parambazi;
      localObject1 = (bbaa)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      parambazi.jdField_a_of_type_Bbaa = ((bbaa)localObject1);
      parambazi.jdField_a_of_type_Int = paramInt;
      this.a.k();
      if (!TextUtils.isEmpty(((bbaa)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
        parambazi.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bbaa)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
        if (((bbaa)localObject1).jdField_b_of_type_Int / ((bbaa)localObject1).jdField_a_of_type_Int > 0.75F)
        {
          parambazi.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          parambazi.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject2 = URLDrawable.getDrawable(((bbaa)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bcuq.t);
          parambazi.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if (((bbaa)localObject1).jdField_a_of_type_AndroidTextSpannable == null) {
            ((bbaa)localObject1).jdField_a_of_type_AndroidTextSpannable = this.a.a((bbaa)localObject1);
          }
          parambazi.jdField_c_of_type_AndroidWidgetTextView.setText(((bbaa)localObject1).jdField_a_of_type_AndroidTextSpannable);
          parambazi.jdField_b_of_type_AndroidWidgetTextView.setText(((bbaa)localObject1).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((bbaa)localObject1).jdField_l_of_type_JavaLangString)) {
            break label512;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = bdda.b();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          localObject2 = URLDrawable.getDrawable(((bbaa)localObject1).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bcuq.a);
          parambazi.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label304:
          if (!((bbaa)localObject1).d) {
            break label525;
          }
          parambazi.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843175);
          parambazi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          label329:
          if ((((bbaa)localObject1).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((bbaa)localObject1).jdField_c_of_type_Boolean)) {
            break label547;
          }
          parambazi.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label362:
          parambazi.jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((bbaa)localObject1).jdField_l_of_type_Int));
          parambazi.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject2 = parambazi.i;
          if (((bbaa)localObject1).jdField_k_of_type_Int == 0) {
            break label579;
          }
          paramInt = 2130843169;
          label405:
          ((ImageView)localObject2).setImageResource(paramInt);
          parambazi.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((bbaa)localObject1).m));
          parambazi.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((bazl)parambazi.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((bbaa)localObject1).jdField_a_of_type_JavaUtilArrayList, (bbaa)localObject1);
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
      parambazi.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      parambazi.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      parambazi.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      parambazi.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bdda.b());
      break label304;
      parambazi.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843174);
      parambazi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label329;
      parambazi.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      parambazi.l.clearAnimation();
      parambazi.k.clearAnimation();
      parambazi.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label362;
      paramInt = 2130843168;
      break label405;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (bazz)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        parambazi = (bazh)parambazi;
        this.a.k();
        parambazi.jdField_a_of_type_Bazz = ((bazz)localObject1);
        parambazi.jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((bazz)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          parambazi.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bazz)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
          if (((bazz)localObject1).jdField_a_of_type_Boolean)
          {
            parambazi.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            parambazi.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject2 = URLDrawable.getDrawable(((bazz)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bcuq.t);
            parambazi.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            parambazi.jdField_b_of_type_AndroidWidgetTextView.setText(((bazz)localObject1).d);
            if (TextUtils.isEmpty(((bazz)localObject1).e)) {
              break label982;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = bdda.b();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            localObject2 = URLDrawable.getDrawable(((bazz)localObject1).e, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bcuq.a);
            parambazi.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            parambazi.jdField_c_of_type_AndroidWidgetTextView.setText(((bazz)localObject1).f);
            parambazi.jdField_a_of_type_AndroidViewView.clearAnimation();
            parambazi.jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((bazz)localObject1).jdField_a_of_type_Int != 12) {
              break label1005;
            }
            localObject2 = parambazi.jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((bazz)localObject1).g)) {
              break label995;
            }
          }
        }
        for (parambazi = alpo.a(2131715483);; parambazi = alpo.a(2131715494))
        {
          ((TextView)localObject2).setText(parambazi);
          return;
          parambazi.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          parambazi.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          parambazi.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break;
          parambazi.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bdda.b());
          break label849;
        }
        parambazi.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715482));
        return;
      }
    } while (getItemViewType(paramInt) != 2);
    ((bazj)parambazi).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Bazn.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof bbaa)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazn
 * JD-Core Version:    0.7.0.1
 */