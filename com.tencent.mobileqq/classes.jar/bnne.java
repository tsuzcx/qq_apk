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

public class bnne
  extends RecyclerView.Adapter<bnnh>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bnng jdField_a_of_type_Bnng;
  private List<bnkg> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public bnne(Context paramContext, List<bnkg> paramList)
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bpdd.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bpdd.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
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
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bpdd.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
        return;
      }
    } while (paramInt >= j);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bpdd.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
  }
  
  public bnnh a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new bnnh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558591, paramViewGroup, false));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    bnrh.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside], position=" + paramInt + ", mClickedPos=" + this.jdField_a_of_type_Int + ", mActivatedPos=" + this.b);
    bnkg localbnkg = (bnkg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if ((localbnkg.jdField_a_of_type_Int == 2) || (localbnkg.b == 1))
    {
      bnrh.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state == STATE_DOWNLOADED || materialWrapper.type == AEMaterialWrapper.TYPE_PLACEHOLDER");
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
    bnrh.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state != STATE_DOWNLOADED");
  }
  
  public void a(@NonNull bnkg parambnkg, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambnkg);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = this.b;
      notifyItemChanged(i);
    }
    do
    {
      return;
      if (parambnkg.jdField_a_of_type_Int != 2) {
        break;
      }
    } while (i != this.jdField_a_of_type_Int);
    c(i);
    int j = this.b;
    this.b = i;
    notifyItemChanged(i);
    notifyItemChanged(j);
    bnqq.a().k(parambnkg.jdField_a_of_type_JavaLangString);
    bnqm.a().ai();
    bnrh.b("AEGIFStickerAdapter", "[notifyDownloadStateChanged], gifMaterialDownloaded, id=" + parambnkg.jdField_a_of_type_JavaLangString);
    return;
    notifyItemChanged(i);
  }
  
  public void a(bnng parambnng)
  {
    this.jdField_a_of_type_Bnng = parambnng;
  }
  
  public void a(bnnh parambnnh, int paramInt)
  {
    Object localObject1 = (bnkg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((bnkg)localObject1).b == 1)
    {
      parambnnh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837969);
      parambnnh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      parambnnh.itemView.setOnClickListener(new bnnf(this, paramInt, (bnkg)localObject1));
      if (paramInt != this.b) {
        break label250;
      }
      bnqq.a().k(((bnkg)localObject1).jdField_a_of_type_JavaLangString);
      localObject1 = parambnnh.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = bpdd.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = bpdd.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      parambnnh.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      parambnnh.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837990);
      parambnnh.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambnnh, paramInt, getItemId(paramInt));
      return;
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837993);
      localObject2 = VasApngUtil.getApngURLDrawable(((bnkg)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      parambnnh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((bnkg)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
      case 2: 
        parambnnh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        parambnnh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
        label250:
        localObject1 = parambnnh.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = bpdd.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        ((ViewGroup.LayoutParams)localObject1).height = bpdd.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        parambnnh.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        parambnnh.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837989);
        parambnnh.b.setVisibility(4);
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
 * Qualified Name:     bnne
 * JD-Core Version:    0.7.0.1
 */