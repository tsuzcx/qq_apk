import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public abstract class bmyl
  extends ReportFragment
{
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public bmyh a;
  public bmyp a;
  public bmzd a;
  AlbumListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData;
  XFrameLayout jdField_a_of_type_ComTencentWidgetXFrameLayout;
  public XListView a;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout = ((XFrameLayout)paramView.findViewById(2131370209));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout.setCornerRadiusAndMode(Utils.dp2px(10.0D), 5);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131362585));
    this.jdField_a_of_type_ComTencentWidgetXListView.setWrapByScroll(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bmyh);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bmyo(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362616));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new bmym(this));
    paramView.findViewById(2131362615).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new bmyn(this, i, j));
    this.jdField_a_of_type_Bmzd.b();
  }
  
  protected abstract bmzd a();
  
  public void a(bmyp parambmyp)
  {
    this.jdField_a_of_type_Bmyp = parambmyp;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561007, paramViewGroup, false);
    this.jdField_a_of_type_Bmzd = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData = this.jdField_a_of_type_Bmzd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_Bmzd.a(paramViewGroup);
    a(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Bmzd != null) {
      this.jdField_a_of_type_Bmzd.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyl
 * JD-Core Version:    0.7.0.1
 */