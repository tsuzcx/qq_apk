import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class blxu
  extends RecyclerView.Adapter<blxx>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blxw jdField_a_of_type_Blxw;
  private List<blvd> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public blxu(Context paramContext, List<blvd> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void b(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      i = localLinearLayoutManager.findFirstVisibleItemPosition();
      i = (localLinearLayoutManager.findLastVisibleItemPosition() - i + 1) / 2 + i;
      if (paramInt <= i) {
        break label62;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bnnl.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bnnl.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
  }
  
  private void c(int paramInt)
  {
    int j;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      int i = localLinearLayoutManager.findFirstVisibleItemPosition();
      j = (localLinearLayoutManager.findLastVisibleItemPosition() - i + 1) / 2 + i;
      if ((paramInt >= i) && (paramInt <= j)) {
        break label58;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    }
    label58:
    do
    {
      return;
      if (paramInt > j)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bnnl.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
        return;
      }
    } while (paramInt >= j);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bnnl.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
  }
  
  public blxx a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new blxx(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558579, paramViewGroup, false));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    bmbx.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside], position=" + paramInt + ", mClickedPos=" + this.jdField_a_of_type_Int + ", mActivatedPos=" + this.b);
    blvd localblvd = (blvd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if ((localblvd.jdField_a_of_type_Int == 2) || (localblvd.b == 1))
    {
      bmbx.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state == STATE_DOWNLOADED || materialWrapper.type == AEMaterialWrapper.TYPE_PLACEHOLDER");
      if (paramInt != this.b)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
        }
        int i = this.b;
        this.b = paramInt;
        notifyItemChanged(paramInt);
        notifyItemChanged(i);
      }
      return;
    }
    bmbx.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state != STATE_DOWNLOADED");
  }
  
  public void a(@NonNull blvd paramblvd, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramblvd);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = this.b;
      notifyItemChanged(i);
    }
    do
    {
      return;
      if (paramblvd.jdField_a_of_type_Int != 2) {
        break;
      }
    } while (i != this.jdField_a_of_type_Int);
    c(i);
    int j = this.b;
    this.b = i;
    notifyItemChanged(i);
    notifyItemChanged(j);
    bmbg.a().k(paramblvd.jdField_a_of_type_JavaLangString);
    bmbc.a().ai();
    bmbx.b("AEGIFStickerAdapter", "[notifyDownloadStateChanged], gifMaterialDownloaded, id=" + paramblvd.jdField_a_of_type_JavaLangString);
    return;
    notifyItemChanged(i);
  }
  
  public void a(blxw paramblxw)
  {
    this.jdField_a_of_type_Blxw = paramblxw;
  }
  
  public void a(blxx paramblxx, int paramInt)
  {
    Object localObject1 = (blvd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((blvd)localObject1).b == 1)
    {
      paramblxx.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837955);
      paramblxx.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramblxx.itemView.setOnClickListener(new blxv(this, paramInt, (blvd)localObject1));
      if (paramInt != this.b) {
        break label250;
      }
      bmbg.a().k(((blvd)localObject1).jdField_a_of_type_JavaLangString);
      localObject1 = paramblxx.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = bnnl.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = bnnl.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      paramblxx.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramblxx.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837976);
      paramblxx.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramblxx, paramInt, getItemId(paramInt));
      return;
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837979);
      localObject2 = VasApngUtil.getApngURLDrawable(((blvd)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      paramblxx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((blvd)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
      case 2: 
        paramblxx.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        paramblxx.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
        label250:
        localObject1 = paramblxx.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = bnnl.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        ((ViewGroup.LayoutParams)localObject1).height = bnnl.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        paramblxx.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramblxx.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837975);
        paramblxx.b.setVisibility(4);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxu
 * JD-Core Version:    0.7.0.1
 */