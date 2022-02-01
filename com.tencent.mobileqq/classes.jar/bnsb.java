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

public class bnsb
  extends RecyclerView.Adapter<bnse>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bnsd jdField_a_of_type_Bnsd;
  private List<bnpk> jdField_a_of_type_JavaUtilList;
  
  public bnsb(Context paramContext, List<bnpk> paramList)
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(bppm.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-bppm.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 60.0F), 0);
  }
  
  public bnse a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new bnse(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558574, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    bnzb.b("AEGIFStickerAdapter", "onItemSelectedFromOutside---position=" + paramInt);
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
  
  public void a(bnsd parambnsd)
  {
    this.jdField_a_of_type_Bnsd = parambnsd;
  }
  
  public void a(bnse parambnse, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramInt == 0)
    {
      parambnse.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837923);
      parambnse.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      parambnse.itemView.setOnClickListener(new bnsc(this, paramInt));
      if (paramInt != this.jdField_a_of_type_Int) {
        break label288;
      }
      localObject2 = bnyl.a();
      if (paramInt != 0) {
        break label266;
      }
      localObject1 = "none";
      label58:
      ((bnyl)localObject2).k((String)localObject1);
      localObject1 = parambnse.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = bppm.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = bppm.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      parambnse.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      parambnse.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837944);
      parambnse.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambnse, paramInt, getItemId(paramInt));
      return;
      localObject1 = (bnpk)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837947);
      localObject2 = VasApngUtil.getApngURLDrawable(((bnpk)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      parambnse.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((bnpk)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
        parambnse.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 2: 
        parambnse.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        parambnse.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
        label266:
        localObject1 = ((bnpk)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1)).jdField_a_of_type_JavaLangString;
        break label58;
        label288:
        localObject1 = parambnse.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = bppm.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        ((ViewGroup.LayoutParams)localObject1).height = bppm.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        parambnse.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        parambnse.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837943);
        parambnse.b.setVisibility(4);
      }
    }
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
 * Qualified Name:     bnsb
 * JD-Core Version:    0.7.0.1
 */