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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter.1;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bqxp
  extends RecyclerView.Adapter<bqxq>
  implements zjs
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<SlideItemInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private zkm jdField_a_of_type_Zkm;
  
  public bqxp(HorizontalAlumbListLayout paramHorizontalAlumbListLayout, Context paramContext, View.OnClickListener paramOnClickListener, zkm paramzkm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Zkm = paramzkm;
  }
  
  public bqxq a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new bqxq(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561804, paramViewGroup, false));
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
      if (this.jdField_a_of_type_Zkm != null) {
        this.jdField_a_of_type_Zkm.a(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void a(bqxq parambqxq, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localSlideItemInfo);
    if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null)
    {
      Object localObject = parambqxq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = beyq.a(localSlideItemInfo.jdField_a_of_type_JavaNetURL, beyq.b(), beyq.a());
        ((URLDrawable)localObject).setTag(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        parambqxq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
        parambqxq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
      }
    }
    switch (localSlideItemInfo.jdField_b_of_type_Int)
    {
    default: 
      if ((paramInt == this.jdField_a_of_type_Int) && (!parambqxq.jdField_a_of_type_Boolean))
      {
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(0.94F);
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(0.94F);
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        parambqxq.jdField_a_of_type_AndroidWidgetTextView.post(new HorizontalAlumbListLayout.SlideShowAdapter.1(this, parambqxq));
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambqxq, paramInt, getItemId(paramInt));
      return;
      parambqxq.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      parambqxq.jdField_b_of_type_AndroidWidgetTextView.setText(zkj.a(localSlideItemInfo.jdField_a_of_type_Long));
      break;
      parambqxq.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (localSlideItemInfo.jdField_a_of_type_Long <= 0L) {
        break;
      }
      parambqxq.jdField_b_of_type_AndroidWidgetTextView.setText(zkj.a(localSlideItemInfo.c - localSlideItemInfo.jdField_b_of_type_Long));
      break;
      if (parambqxq.jdField_a_of_type_Boolean)
      {
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.13F);
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.13F);
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.65F);
        parambqxq.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      else
      {
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
        parambqxq.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        parambqxq.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
    }
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
 * Qualified Name:     bqxp
 * JD-Core Version:    0.7.0.1
 */