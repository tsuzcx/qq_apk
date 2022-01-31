import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.image.URLDrawable;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bneo
  extends RecyclerView.Adapter<bnep>
  implements xmm
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<SlideItemInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private xng jdField_a_of_type_Xng;
  
  public bneo(HorizontalAlumbListLayout paramHorizontalAlumbListLayout, Context paramContext, View.OnClickListener paramOnClickListener, xng paramxng)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Xng = paramxng;
  }
  
  public bnep a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new bnep(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561528, paramViewGroup, false));
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(4);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Collections.swap(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_Int == paramInt1) || (this.jdField_a_of_type_Int == paramInt2)) {
      if (this.jdField_a_of_type_Int != paramInt1) {
        break label81;
      }
    }
    label81:
    for (this.jdField_a_of_type_Int = paramInt2;; this.jdField_a_of_type_Int = paramInt1)
    {
      notifyItemChanged(paramInt1, Integer.valueOf(0));
      notifyItemChanged(paramInt2, Integer.valueOf(0));
      if (this.jdField_a_of_type_Xng != null) {
        this.jdField_a_of_type_Xng.a(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void a(bnep parambnep, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localSlideItemInfo);
    if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null)
    {
      Object localObject = parambnep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = bayu.a(localSlideItemInfo.jdField_a_of_type_JavaNetURL, bayu.b(), bayu.a());
        ((URLDrawable)localObject).setTag(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        parambnep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
        parambnep.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
      }
    }
    switch (localSlideItemInfo.jdField_b_of_type_Int)
    {
    }
    while ((paramInt == this.jdField_a_of_type_Int) && (!parambnep.jdField_a_of_type_Boolean))
    {
      parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(0.94F);
      parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(0.94F);
      parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      parambnep.jdField_a_of_type_AndroidWidgetTextView.post(new HorizontalAlumbListLayout.SlideShowAdapter.1(this, parambnep));
      return;
      parambnep.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      parambnep.jdField_b_of_type_AndroidWidgetTextView.setText(xnd.a(localSlideItemInfo.jdField_a_of_type_Long));
      continue;
      parambnep.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (localSlideItemInfo.jdField_a_of_type_Long > 0L) {
        parambnep.jdField_b_of_type_AndroidWidgetTextView.setText(xnd.a(localSlideItemInfo.c - localSlideItemInfo.jdField_b_of_type_Long));
      }
    }
    if (parambnep.jdField_a_of_type_Boolean)
    {
      parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.13F);
      parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.13F);
      parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.65F);
      parambnep.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      return;
    }
    parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
    parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
    parambnep.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
    parambnep.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneo
 * JD-Core Version:    0.7.0.1
 */