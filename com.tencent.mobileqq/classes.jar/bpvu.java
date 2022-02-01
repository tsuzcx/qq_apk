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

public class bpvu
  extends RecyclerView.Adapter<bpvv>
  implements zfx
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<SlideItemInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private zgr jdField_a_of_type_Zgr;
  
  public bpvu(HorizontalAlumbListLayout paramHorizontalAlumbListLayout, Context paramContext, View.OnClickListener paramOnClickListener, zgr paramzgr)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Zgr = paramzgr;
  }
  
  public bpvv a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new bpvv(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561763, paramViewGroup, false));
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
      if (this.jdField_a_of_type_Zgr != null) {
        this.jdField_a_of_type_Zgr.a(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void a(bpvv parambpvv, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localSlideItemInfo);
    if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null)
    {
      Object localObject = parambpvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = bdzx.a(localSlideItemInfo.jdField_a_of_type_JavaNetURL, bdzx.b(), bdzx.a());
        ((URLDrawable)localObject).setTag(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        parambpvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
        parambpvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
      }
    }
    switch (localSlideItemInfo.jdField_b_of_type_Int)
    {
    default: 
      if ((paramInt == this.jdField_a_of_type_Int) && (!parambpvv.jdField_a_of_type_Boolean))
      {
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(0.94F);
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(0.94F);
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        parambpvv.jdField_a_of_type_AndroidWidgetTextView.post(new HorizontalAlumbListLayout.SlideShowAdapter.1(this, parambpvv));
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambpvv, paramInt, getItemId(paramInt));
      return;
      parambpvv.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      parambpvv.jdField_b_of_type_AndroidWidgetTextView.setText(zgo.a(localSlideItemInfo.jdField_a_of_type_Long));
      break;
      parambpvv.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (localSlideItemInfo.jdField_a_of_type_Long <= 0L) {
        break;
      }
      parambpvv.jdField_b_of_type_AndroidWidgetTextView.setText(zgo.a(localSlideItemInfo.c - localSlideItemInfo.jdField_b_of_type_Long));
      break;
      if (parambpvv.jdField_a_of_type_Boolean)
      {
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.13F);
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.13F);
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.65F);
        parambpvv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      else
      {
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
        parambpvv.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        parambpvv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
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
 * Qualified Name:     bpvu
 * JD-Core Version:    0.7.0.1
 */