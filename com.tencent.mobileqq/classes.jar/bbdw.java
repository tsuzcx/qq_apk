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

public class bbdw
  extends RecyclerView.Adapter<bbdr>
{
  public bbdw(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public bbdr a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560388, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new bbdx(this));
      paramViewGroup = new bbea(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364609));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373138));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373136));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367573));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131380031));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367576));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365125));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131372359));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366721));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366706));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366727));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131366725));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131366726));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366711));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366710));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366709));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366712));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366723));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131366715));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366717));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131366713));
      paramViewGroup.i.setImageResource(2130843181);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131366716));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131378288));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361842));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131367569));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131367568));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131367566));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131367571));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367572));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(bdaq.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new bbdu(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new bbdy(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560387, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new bbdz(this));
        localObject = new bbdq(this.a, paramViewGroup);
        ((bbdq)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364609));
        ((bbdq)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373138));
        ((bbdq)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373136));
        ((bbdq)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367092));
        ((bbdq)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367097));
        ((bbdq)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367099));
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131372359));
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367074));
        ((bbdq)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131361966);
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367089));
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131361967));
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131361969));
        ((bbdq)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bbdq)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((bbdq)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((bbdq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new bbds(this.a, paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(bbdr parambbdr, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 0)
    {
      parambbdr = (bbea)parambbdr;
      localObject1 = (bbej)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      parambbdr.jdField_a_of_type_Bbej = ((bbej)localObject1);
      parambbdr.jdField_a_of_type_Int = paramInt;
      this.a.k();
      if (!TextUtils.isEmpty(((bbej)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
        parambbdr.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bbej)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
        if (((bbej)localObject1).jdField_b_of_type_Int / ((bbej)localObject1).jdField_a_of_type_Int > 0.75F)
        {
          parambbdr.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          parambbdr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject2 = URLDrawable.getDrawable(((bbej)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bcyz.t);
          parambbdr.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if (((bbej)localObject1).jdField_a_of_type_AndroidTextSpannable == null) {
            ((bbej)localObject1).jdField_a_of_type_AndroidTextSpannable = this.a.a((bbej)localObject1);
          }
          parambbdr.jdField_c_of_type_AndroidWidgetTextView.setText(((bbej)localObject1).jdField_a_of_type_AndroidTextSpannable);
          parambbdr.jdField_b_of_type_AndroidWidgetTextView.setText(((bbej)localObject1).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((bbej)localObject1).jdField_l_of_type_JavaLangString)) {
            break label512;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = bdhj.b();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          localObject2 = URLDrawable.getDrawable(((bbej)localObject1).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bcyz.a);
          parambbdr.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label304:
          if (!((bbej)localObject1).d) {
            break label525;
          }
          parambbdr.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843188);
          parambbdr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          label329:
          if ((((bbej)localObject1).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((bbej)localObject1).jdField_c_of_type_Boolean)) {
            break label547;
          }
          parambbdr.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label362:
          parambbdr.jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((bbej)localObject1).jdField_l_of_type_Int));
          parambbdr.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject2 = parambbdr.i;
          if (((bbej)localObject1).jdField_k_of_type_Int == 0) {
            break label579;
          }
          paramInt = 2130843182;
          label405:
          ((ImageView)localObject2).setImageResource(paramInt);
          parambbdr.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((bbej)localObject1).m));
          parambbdr.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((bbdu)parambbdr.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((bbej)localObject1).jdField_a_of_type_JavaUtilArrayList, (bbej)localObject1);
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
      parambbdr.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      parambbdr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      parambbdr.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      parambbdr.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bdhj.b());
      break label304;
      parambbdr.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843187);
      parambbdr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label329;
      parambbdr.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      parambbdr.l.clearAnimation();
      parambbdr.k.clearAnimation();
      parambbdr.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label362;
      paramInt = 2130843181;
      break label405;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (bbei)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        parambbdr = (bbdq)parambbdr;
        this.a.k();
        parambbdr.jdField_a_of_type_Bbei = ((bbei)localObject1);
        parambbdr.jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((bbei)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
          parambbdr.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((bbei)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
          if (((bbei)localObject1).jdField_a_of_type_Boolean)
          {
            parambbdr.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            parambbdr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject2 = URLDrawable.getDrawable(((bbei)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bcyz.t);
            parambbdr.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            parambbdr.jdField_b_of_type_AndroidWidgetTextView.setText(((bbei)localObject1).d);
            if (TextUtils.isEmpty(((bbei)localObject1).e)) {
              break label982;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = bdhj.b();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
            localObject2 = URLDrawable.getDrawable(((bbei)localObject1).e, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bcyz.a);
            parambbdr.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            parambbdr.jdField_c_of_type_AndroidWidgetTextView.setText(((bbei)localObject1).f);
            parambbdr.jdField_a_of_type_AndroidViewView.clearAnimation();
            parambbdr.jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((bbei)localObject1).jdField_a_of_type_Int != 12) {
              break label1005;
            }
            localObject2 = parambbdr.jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((bbei)localObject1).g)) {
              break label995;
            }
          }
        }
        for (parambbdr = alud.a(2131715495);; parambbdr = alud.a(2131715506))
        {
          ((TextView)localObject2).setText(parambbdr);
          return;
          parambbdr.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          parambbdr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          parambbdr.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break;
          parambbdr.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bdhj.b());
          break label849;
        }
        parambbdr.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131715494));
        return;
      }
    } while (getItemViewType(paramInt) != 2);
    ((bbds)parambbdr).jdField_a_of_type_Int = (this.a.jdField_a_of_type_Bbdw.getItemCount() - 1);
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
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof bbej)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdw
 * JD-Core Version:    0.7.0.1
 */