import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import java.util.List;

public class blct
  extends RecyclerView.Adapter<blcw>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blcv jdField_a_of_type_Blcv;
  private List<blag> jdField_a_of_type_JavaUtilList;
  
  public blct(Context paramContext, List<blag> paramList)
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bmyg.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bmyg.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
  }
  
  public blcw a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new blcw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558547, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    bljn.b("AEGIFStickerAdapter", "onItemSelectedFromOutside---position=" + paramInt);
    if (paramInt != this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
      }
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      notifyItemChanged(paramInt);
      notifyItemChanged(i);
    }
  }
  
  public void a(blcv paramblcv)
  {
    this.jdField_a_of_type_Blcv = paramblcv;
  }
  
  public void a(blcw paramblcw, int paramInt)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      paramblcw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837695);
      paramblcw.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramblcw.itemView.setOnClickListener(new blcu(this, paramInt));
      if (paramInt != this.jdField_a_of_type_Int) {
        break label276;
      }
      localObject2 = bliy.a();
      if (paramInt != 0) {
        break label254;
      }
    }
    label254:
    for (Object localObject1 = "none";; localObject1 = ((blag)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1)).jdField_a_of_type_JavaLangString)
    {
      ((bliy)localObject2).k((String)localObject1);
      localObject1 = paramblcw.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = bmyg.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = bmyg.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      paramblcw.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramblcw.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837716);
      paramblcw.b.setVisibility(0);
      return;
      localObject1 = (blag)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837719);
      localObject2 = bduc.a(((blag)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      paramblcw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((blag)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
        paramblcw.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 2: 
        paramblcw.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        paramblcw.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
      }
    }
    label276:
    localObject1 = paramblcw.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = bmyg.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
    ((ViewGroup.LayoutParams)localObject1).height = bmyg.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
    paramblcw.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramblcw.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837715);
    paramblcw.b.setVisibility(4);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blct
 * JD-Core Version:    0.7.0.1
 */