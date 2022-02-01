import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.ui.panel.AEGridView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.1;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.3;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.4;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnmn
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, bcha, bnpq
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bnmu jdField_a_of_type_Bnmu;
  private bnpc jdField_a_of_type_Bnpc;
  public bnpf a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public ArrayList<bnpf> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bnmn(Context paramContext, AEGridView paramAEGridView, bnmu parambnmu, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bnpc = ((bnpc)bojv.a(18));
    this.jdField_a_of_type_Bnmu = parambnmu;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(bnpf parambnpf)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((bnpf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambnpf.jdField_a_of_type_JavaLangString)) {
        return i;
      }
      i += 1;
    }
    return 0;
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((bnpf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((bnpf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(bnpf parambnpf)
  {
    if (parambnpf == null) {}
    while ((parambnpf.f) || (TextUtils.isEmpty(parambnpf.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bnpc == null)) {
      return;
    }
    if (!bgnt.b(this.jdField_a_of_type_AndroidContentContext))
    {
      d(parambnpf);
      return;
    }
    c(parambnpf);
  }
  
  private void b(bnpf parambnpf, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambnpf == null) {}
    label400:
    for (;;)
    {
      return;
      bnyl.a().b(-1);
      bnyl.a().g("none");
      bnyl.a().f("1");
      bnyl.a().c(0);
      Object localObject;
      if (parambnpf != null)
      {
        bnyh.a().d(parambnpf.jdField_a_of_type_JavaLangString);
        bnzb.b("AEMaterialAdapter", "【Select Material】：" + parambnpf.jdField_a_of_type_JavaLangString);
        bnzb.b("AEMaterialAdapter", "【Select Material】Usable :" + parambnpf.e);
        if ((parambnpf != null) && (!TextUtils.isEmpty(parambnpf.jdField_a_of_type_JavaLangString)) && (!bnpf.a(parambnpf))) {
          break label216;
        }
        if (this.jdField_a_of_type_Bnmu != null) {
          this.jdField_a_of_type_Bnmu.a();
        }
        parambnpf = this.jdField_a_of_type_Bnpc;
        localObject = bnpf.jdField_a_of_type_Bnpf;
        if (this.jdField_a_of_type_Boolean) {
          break label211;
        }
      }
      for (;;)
      {
        parambnpf.a((bnpf)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bnyh.a().d("null");
        bnzb.b("AEMaterialAdapter", "【Select Material】：null");
        break;
        label211:
        bool1 = false;
      }
      label216:
      if (parambnpf.a())
      {
        zmi.a(this.jdField_a_of_type_AndroidContentContext, parambnpf);
        return;
      }
      if (parambnpf.e)
      {
        if (!bnpy.a())
        {
          QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131708589), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Bnmu != null) {
          this.jdField_a_of_type_Bnmu.a(parambnpf);
        }
        localObject = this.jdField_a_of_type_Bnpc;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          ((bnpc)localObject).a(parambnpf, bool1);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + parambnpf.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label400;
        }
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (!bnqb.j(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))) {
          break label402;
        }
        this.jdField_a_of_type_Bnpc.b(parambnpf);
        return;
        bool1 = false;
        break;
        b(parambnpf);
      }
    }
    label402:
    this.jdField_a_of_type_Bnpc.a(parambnpf);
  }
  
  private void c(bnpf parambnpf)
  {
    parambnpf = bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(anni.a(2131708592)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131697516)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694081), new bnmp(this, parambnpf)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690582), new bnmo(this));
    if (parambnpf != null) {}
    try
    {
      if (!parambnpf.isShowing()) {
        parambnpf.show();
      }
      return;
    }
    catch (Throwable parambnpf) {}
  }
  
  private void d(bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnpc.a(this.jdField_a_of_type_Bnpc.a(), parambnpf, this);
  }
  
  public void a(bnpf parambnpf)
  {
    b(parambnpf, a(parambnpf));
  }
  
  public void a(bnpf parambnpf, int paramInt)
  {
    paramInt = a(parambnpf);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(bnpf parambnpf, boolean paramBoolean)
  {
    if (parambnpf == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(parambnpf);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, parambnpf, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (bnpc.a() != null) {
        notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 111) {
            break;
          }
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!this.jdField_a_of_type_Boolean));
        a(((bnpb)paramVarArgs[0]).a);
        notifyDataSetChanged();
        return;
        if (paramInt != 114) {
          break;
        }
      } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
      a(true, paramVarArgs[0]);
      return;
    } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
    a(false, paramVarArgs[0]);
  }
  
  public void a(List<bnpf> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(bnpf.jdField_a_of_type_Bnpf);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
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
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    bnpf localbnpf = (bnpf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbnpf == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      if ((paramViewHolder instanceof bnnc))
      {
        localObject = (bnnc)paramViewHolder;
        if (localbnpf.equals(bnpc.a())) {
          ((bnnc)localObject).a();
        } else {
          ((bnnc)localObject).b();
        }
      }
      else if ((paramViewHolder instanceof bnnd))
      {
        localObject = (bnnd)paramViewHolder;
        if ((localbnpf.equals(bnpc.a())) && (localbnpf.e))
        {
          ((bnnd)localObject).a(2, localbnpf);
        }
        else
        {
          localbnpf.jdField_a_of_type_Boolean = false;
          ((bnnd)localObject).a(1, localbnpf);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bnpf localbnpf = (bnpf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((this.jdField_a_of_type_Bnpf != null) && (!this.jdField_a_of_type_Bnpf.equals(localbnpf)))
    {
      this.jdField_a_of_type_Bnpf.b = false;
      this.jdField_a_of_type_Bnpf.c = false;
    }
    this.jdField_a_of_type_Bnpf = localbnpf;
    if (localbnpf.b) {
      localbnpf.c = true;
    }
    for (;;)
    {
      b(localbnpf, i);
      break;
      localbnpf.b = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558502, paramViewGroup, false);
      paramViewGroup = new bnnc(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558501, paramViewGroup, false);
      paramViewGroup = new bnnd(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmn
 * JD-Core Version:    0.7.0.1
 */