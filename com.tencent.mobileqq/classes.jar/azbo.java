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

public class azbo
  extends RecyclerView.Adapter<azbj>
{
  public azbo(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public azbj a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560281, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new azbp(this));
      paramViewGroup = new azbs(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364533));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131372756));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131372754));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367435));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131379272));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367438));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365038));
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
      paramViewGroup.i.setImageResource(2130842984);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131366591));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131377693));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361842));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367431));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367430));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367428));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367433));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367434));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(baxn.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new azbm(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new azbq(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560280, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new azbr(this));
        localObject = new azbi(this.a, paramViewGroup);
        ((azbi)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364533));
        ((azbi)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372756));
        ((azbi)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372754));
        ((azbi)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366960));
        ((azbi)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366965));
        ((azbi)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366967));
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131372022));
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366943));
        ((azbi)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131361964);
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131366958));
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131361965));
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131361967));
        ((azbi)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((azbi)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((azbi)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((azbi)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new azbk(this.a, paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(azbj paramazbj, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 0)
    {
      paramazbj = (azbs)paramazbj;
      localObject1 = (azcb)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramazbj.jdField_a_of_type_Azcb = ((azcb)localObject1);
      paramazbj.jdField_a_of_type_Int = paramInt;
      this.a.k();
      if (!TextUtils.isEmpty(((azcb)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
        paramazbj.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((azcb)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
        if (((azcb)localObject1).jdField_b_of_type_Int / ((azcb)localObject1).jdField_a_of_type_Int > 0.75F)
        {
          paramazbj.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramazbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject2 = URLDrawable.getDrawable(((azcb)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bavw.t);
          paramazbj.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if (((azcb)localObject1).jdField_a_of_type_AndroidTextSpannable == null) {
            ((azcb)localObject1).jdField_a_of_type_AndroidTextSpannable = this.a.a((azcb)localObject1);
          }
          paramazbj.jdField_c_of_type_AndroidWidgetTextView.setText(((azcb)localObject1).jdField_a_of_type_AndroidTextSpannable);
          paramazbj.jdField_b_of_type_AndroidWidgetTextView.setText(((azcb)localObject1).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((azcb)localObject1).jdField_l_of_type_JavaLangString)) {
            break label512;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = bbef.b();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          localObject2 = URLDrawable.getDrawable(((azcb)localObject1).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bavw.a);
          paramazbj.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label304:
          if (!((azcb)localObject1).d) {
            break label525;
          }
          paramazbj.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842991);
          paramazbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          label329:
          if ((((azcb)localObject1).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((azcb)localObject1).jdField_c_of_type_Boolean)) {
            break label547;
          }
          paramazbj.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label362:
          paramazbj.jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((azcb)localObject1).jdField_l_of_type_Int));
          paramazbj.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject2 = paramazbj.i;
          if (((azcb)localObject1).jdField_k_of_type_Int == 0) {
            break label579;
          }
          paramInt = 2130842985;
          label405:
          ((ImageView)localObject2).setImageResource(paramInt);
          paramazbj.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((azcb)localObject1).m));
          paramazbj.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((azbm)paramazbj.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((azcb)localObject1).jdField_a_of_type_JavaUtilArrayList, (azcb)localObject1);
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
      paramazbj.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramazbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      paramazbj.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      paramazbj.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bbef.b());
      break label304;
      paramazbj.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842990);
      paramazbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label329;
      paramazbj.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramazbj.l.clearAnimation();
      paramazbj.k.clearAnimation();
      paramazbj.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label362;
      paramInt = 2130842984;
      break label405;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (azca)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramazbj = (azbi)paramazbj;
        this.a.k();
        paramazbj.jdField_a_of_type_Azca = ((azca)localObject1);
        paramazbj.jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((azca)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          paramazbj.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((azca)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
          if (((azca)localObject1).jdField_a_of_type_Boolean)
          {
            paramazbj.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramazbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject2 = URLDrawable.getDrawable(((azca)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bavw.t);
            paramazbj.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramazbj.jdField_b_of_type_AndroidWidgetTextView.setText(((azca)localObject1).d);
            if (TextUtils.isEmpty(((azca)localObject1).e)) {
              break label982;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = bbef.b();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            localObject2 = URLDrawable.getDrawable(((azca)localObject1).e, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bavw.a);
            paramazbj.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramazbj.jdField_c_of_type_AndroidWidgetTextView.setText(((azca)localObject1).f);
            paramazbj.jdField_a_of_type_AndroidViewView.clearAnimation();
            paramazbj.jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((azca)localObject1).jdField_a_of_type_Int != 12) {
              break label1005;
            }
            localObject2 = paramazbj.jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((azca)localObject1).g)) {
              break label995;
            }
          }
        }
        for (paramazbj = ajya.a(2131715111);; paramazbj = ajya.a(2131715122))
        {
          ((TextView)localObject2).setText(paramazbj);
          return;
          paramazbj.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramazbj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          paramazbj.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break;
          paramazbj.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bbef.b());
          break label849;
        }
        paramazbj.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715110));
        return;
      }
    } while (getItemViewType(paramInt) != 2);
    ((azbk)paramazbj).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Azbo.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof azcb)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbo
 * JD-Core Version:    0.7.0.1
 */