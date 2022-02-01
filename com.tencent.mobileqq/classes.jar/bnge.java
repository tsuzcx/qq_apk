import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.1;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.2;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.3;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.4;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.5;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.6;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.8;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnge
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, bczs, bnkq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bngl jdField_a_of_type_Bngl;
  private bnkb jdField_a_of_type_Bnkb;
  private bnke jdField_a_of_type_Bnke;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList<bnke> a;
  
  public bnge(Context paramContext, bngl parambngl)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bngl = parambngl;
    this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a(18));
    this.jdField_a_of_type_Bnkb.a(this, 114);
    this.jdField_a_of_type_Bnkb.a(this, 115);
    this.jdField_a_of_type_Bnkb.a(this, 1025);
    this.jdField_a_of_type_Bnkb.a(this, 113);
  }
  
  private int a(bnke parambnke)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambnke.jdField_a_of_type_JavaLangString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(bnke parambnke)
  {
    if ((this.jdField_a_of_type_Bnke != null) && (!this.jdField_a_of_type_Bnke.equals(parambnke)))
    {
      this.jdField_a_of_type_Bnke.b = false;
      this.jdField_a_of_type_Bnke.c = false;
    }
    this.jdField_a_of_type_Bnke = parambnke;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private static void b(RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {}
    LinearLayoutManager localLinearLayoutManager;
    do
    {
      return;
      localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    } while (localLinearLayoutManager == null);
    paramRecyclerView = new bngf(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  private void b(bnke parambnke)
  {
    if (parambnke == null) {}
    while ((parambnke.f) || (TextUtils.isEmpty(parambnke.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bnkb == null)) {
      return;
    }
    c(parambnke);
  }
  
  private void c(bnke parambnke)
  {
    this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnkb.getApp(), parambnke, this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      bnrh.d("AEWaterMarkAdapter", "mTemplateList is null");
      notifyDataSetChanged();
      return;
    }
    bnke localbnke1 = bnkb.b();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      bnke localbnke2 = (bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localbnke1 != null)
      {
        k = j;
        if (localbnke1.jdField_a_of_type_JavaLangString.equals(localbnke2.jdField_a_of_type_JavaLangString)) {
          k = i;
        }
      }
      i += 1;
    }
    a(j);
  }
  
  public void a(int paramInt)
  {
    bnrh.a("AEWaterMarkAdapter", "setSelectedIndex:" + paramInt);
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEWaterMarkAdapter.3(this, paramInt));
    }
  }
  
  public void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bnrh.a("AEWaterMarkAdapter", "setCircleCaptureStyle:" + paramRatio);
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
  }
  
  public void a(List<bnke> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(bnke.jdField_a_of_type_Bnke);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEWaterMarkAdapter.2(this), 200L);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.8(this, paramInt, paramVarArgs));
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    bnke localbnke1 = (bnke)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbnke1 == null) {}
    bnke localbnke2;
    label134:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        localbnke2 = bnkb.b();
        if (!(paramViewHolder instanceof bnfx)) {
          break;
        }
        if (localbnke2 == null)
        {
          ((bnfx)paramViewHolder).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((bnfx)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
            break label134;
          }
          ((bnfx)paramViewHolder).jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837664));
          break;
          ((bnfx)paramViewHolder).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((bnfx)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        ((bnfx)paramViewHolder).jdField_b_of_type_AndroidViewView.setVisibility(0);
        ((bnfx)paramViewHolder).jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167369));
      }
    } while (!(paramViewHolder instanceof bnfy));
    bnfy localbnfy = (bnfy)paramViewHolder;
    localbnfy.a(localbnke1);
    boolean bool;
    if (localbnke2 == null)
    {
      if (paramInt != 0) {
        break label367;
      }
      bool = true;
    }
    for (;;)
    {
      label202:
      if (bool)
      {
        if (localbnke2 != null) {
          localbnke1.jdField_a_of_type_Boolean = localbnke2.jdField_a_of_type_Boolean;
        }
        if (localbnke1.jdField_a_of_type_Boolean)
        {
          localbnfy.e.setVisibility(8);
          localbnfy.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label248:
          localbnfy.a(8);
          localbnfy.b(8);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
          break label365;
        }
        ((bnfy)paramViewHolder).jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837664));
        break;
        bool = localbnke2.jdField_a_of_type_JavaLangString.equals(localbnke1.jdField_a_of_type_JavaLangString);
        break label202;
        localbnfy.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localbnfy.e.setVisibility(0);
        break label248;
        localbnfy.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localbnfy.e.setVisibility(8);
        localbnfy.b(localbnke1);
      }
      label365:
      break;
      label367:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition(paramView);
    if (i == -1) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bngl == null)
      {
        bnrh.d("AEWaterMarkAdapter", "water mark mlistener is null");
      }
      else
      {
        bnke localbnke = (bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((i == 0) || (localbnke == null))
        {
          this.jdField_a_of_type_Bngl.a();
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_Bnkb.b(null, true);
          a(0);
          bnqm.a().av();
        }
        else if ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) && (!localbnke.e))
        {
          bnrh.d("AEWaterMarkAdapter", "net work not available");
          bjkv.a().a(anvx.a(2131715761));
        }
        else
        {
          a(localbnke);
          bnqm localbnqm = bnqm.a();
          String str;
          if (localbnke.jdField_a_of_type_JavaLangString == null)
          {
            str = "none";
            label163:
            localbnqm.l(str);
            if (!localbnke.b) {
              break label261;
            }
            localbnke.c = true;
          }
          for (;;)
          {
            this.jdField_a_of_type_JavaLangString = localbnke.jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_JavaLangString);
            if (!localbnke.e) {
              break label299;
            }
            if (bnky.a()) {
              break label270;
            }
            QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131709277), 0).a();
            ThreadManager.excute(new AEWaterMarkAdapter.1(this), 64, null, true);
            break;
            str = localbnke.jdField_a_of_type_JavaLangString;
            break label163;
            label261:
            localbnke.b = true;
          }
          label270:
          this.jdField_a_of_type_Bnkb.b(localbnke, true);
          this.jdField_a_of_type_Bngl.a(localbnke);
          a(i);
          continue;
          label299:
          b(localbnke);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0) {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558493, paramViewGroup, false);
    }
    for (paramViewGroup = new bnfx(localView);; paramViewGroup = new bnfy(localView, this.jdField_a_of_type_AndroidContentContext))
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558492, paramViewGroup, false);
    }
  }
  
  public void onDownloadFinish(bnke parambnke, boolean paramBoolean)
  {
    if (parambnke == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(parambnke);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.4(this, i, parambnke, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.5(this));
  }
  
  public void onProgressUpdate(bnke parambnke, int paramInt)
  {
    paramInt = a(parambnke);
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.6(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnge
 * JD-Core Version:    0.7.0.1
 */