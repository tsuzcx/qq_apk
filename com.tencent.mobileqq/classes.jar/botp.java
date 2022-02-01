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
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class botp
  extends RecyclerView.Adapter<bots>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private botr jdField_a_of_type_Botr;
  private List<boqw> jdField_a_of_type_JavaUtilList;
  
  public botp(Context paramContext, List<boqw> paramList)
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bqrh.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bqrh.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
  }
  
  public bots a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new bots(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558576, paramViewGroup, false));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    bpam.b("AEGIFStickerAdapter", "onItemSelectedFromOutside---position=" + paramInt);
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
  
  public void a(botr parambotr)
  {
    this.jdField_a_of_type_Botr = parambotr;
  }
  
  public void a(bots parambots, int paramInt)
  {
    Object localObject1 = (boqw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((boqw)localObject1).b == 1)
    {
      parambots.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837930);
      parambots.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      parambots.itemView.setOnClickListener(new botq(this, paramInt, (boqw)localObject1));
      if (paramInt != this.jdField_a_of_type_Int) {
        break label250;
      }
      bozv.a().k(((boqw)localObject1).jdField_a_of_type_JavaLangString);
      localObject1 = parambots.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = bqrh.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = bqrh.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      parambots.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      parambots.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837951);
      parambots.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambots, paramInt, getItemId(paramInt));
      return;
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837954);
      localObject2 = VasApngUtil.getApngURLDrawable(((boqw)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      parambots.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((boqw)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
      case 2: 
        parambots.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        parambots.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
        label250:
        localObject1 = parambots.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = bqrh.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        ((ViewGroup.LayoutParams)localObject1).height = bqrh.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        parambots.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        parambots.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837950);
        parambots.b.setVisibility(4);
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
 * Qualified Name:     botp
 * JD-Core Version:    0.7.0.1
 */