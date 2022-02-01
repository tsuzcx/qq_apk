import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public class avkc
  extends avkb
{
  private ImageView a;
  
  public avkc(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    this.a = ((ImageView)paramView.findViewById(2131363286));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    this.itemView.setBackgroundDrawable(avmd.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130847081);
    localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130847081);
    this.a.setImageDrawable(URLDrawable.getDrawable(paramFeedsItemData.coverImgUrl, localURLDrawableOptions));
    this.a.setOnClickListener(new avkd(this, paramFeedsItemData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkc
 * JD-Core Version:    0.7.0.1
 */