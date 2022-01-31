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

public class bkym
  extends RecyclerView.Adapter<bkyp>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bkyo jdField_a_of_type_Bkyo;
  private List<bkvz> jdField_a_of_type_JavaUtilList;
  
  public bkym(Context paramContext, List<bkvz> paramList)
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bmtu.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bmtu.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
  }
  
  public bkyp a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new bkyp(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558547, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    blfg.b("AEGIFStickerAdapter", "onItemSelectedFromOutside---position=" + paramInt);
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
  
  public void a(bkyo parambkyo)
  {
    this.jdField_a_of_type_Bkyo = parambkyo;
  }
  
  public void a(bkyp parambkyp, int paramInt)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      parambkyp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837694);
      parambkyp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      parambkyp.itemView.setOnClickListener(new bkyn(this, paramInt));
      if (paramInt != this.jdField_a_of_type_Int) {
        break label276;
      }
      localObject2 = bler.a();
      if (paramInt != 0) {
        break label254;
      }
    }
    label254:
    for (Object localObject1 = "none";; localObject1 = ((bkvz)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1)).jdField_a_of_type_JavaLangString)
    {
      ((bler)localObject2).k((String)localObject1);
      localObject1 = parambkyp.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = bmtu.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = bmtu.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      parambkyp.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      parambkyp.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837715);
      parambkyp.b.setVisibility(0);
      return;
      localObject1 = (bkvz)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837718);
      localObject2 = bdpt.a(((bkvz)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      parambkyp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((bkvz)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
        parambkyp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 2: 
        parambkyp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        parambkyp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
      }
    }
    label276:
    localObject1 = parambkyp.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = bmtu.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
    ((ViewGroup.LayoutParams)localObject1).height = bmtu.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
    parambkyp.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    parambkyp.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837714);
    parambkyp.b.setVisibility(4);
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
 * Qualified Name:     bkym
 * JD-Core Version:    0.7.0.1
 */