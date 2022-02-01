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

public class booa
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, bczs, borc
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private boof jdField_a_of_type_Boof;
  private boqr jdField_a_of_type_Boqr;
  public boqu a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public String a;
  public ArrayList<boqu> a;
  private boolean jdField_a_of_type_Boolean;
  
  public booa(Context paramContext, AEGridView paramAEGridView, boof paramboof, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boqr = ((boqr)bplq.a(18));
    this.jdField_a_of_type_Boof = paramboof;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(boqu paramboqu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((boqu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramboqu.jdField_a_of_type_JavaLangString)) {
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((boqu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((boqu)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(boqu paramboqu)
  {
    if ((this.jdField_a_of_type_Boqu != null) && (!this.jdField_a_of_type_Boqu.equals(paramboqu)))
    {
      this.jdField_a_of_type_Boqu.b = false;
      this.jdField_a_of_type_Boqu.c = false;
    }
    this.jdField_a_of_type_Boqu = paramboqu;
  }
  
  private void b(boqu paramboqu, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramboqu == null) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    label424:
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramboqu.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_JavaLangString);
      bozv.a().c(-1);
      bozv.a().g("none");
      bozv.a().f("1");
      bozv.a().d(0);
      Object localObject;
      if (paramboqu != null)
      {
        bozr.a().d(paramboqu.jdField_a_of_type_JavaLangString);
        bpam.b("AEMaterialAdapter", "【Select Material】：" + paramboqu.jdField_a_of_type_JavaLangString);
        bpam.b("AEMaterialAdapter", "【Select Material】Usable :" + paramboqu.e);
        if ((paramboqu != null) && (!TextUtils.isEmpty(paramboqu.jdField_a_of_type_JavaLangString)) && (!boqu.a(paramboqu))) {
          break label240;
        }
        if (this.jdField_a_of_type_Boof != null) {
          this.jdField_a_of_type_Boof.a();
        }
        paramboqu = this.jdField_a_of_type_Boqr;
        localObject = boqu.jdField_a_of_type_Boqu;
        if (this.jdField_a_of_type_Boolean) {
          break label235;
        }
      }
      for (;;)
      {
        paramboqu.a((boqu)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bozr.a().d("null");
        bpam.b("AEMaterialAdapter", "【Select Material】：null");
        break;
        label235:
        bool1 = false;
      }
      label240:
      if (paramboqu.a())
      {
        zqd.a(this.jdField_a_of_type_AndroidContentContext, paramboqu);
        return;
      }
      if (paramboqu.e)
      {
        if (!bork.a())
        {
          QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131708698), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        if (this.jdField_a_of_type_Boof != null) {
          this.jdField_a_of_type_Boof.a(paramboqu);
        }
        localObject = this.jdField_a_of_type_Boqr;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          ((boqr)localObject).a(paramboqu, bool1);
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + paramboqu.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label424;
        }
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (!born.j(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))) {
          break label426;
        }
        this.jdField_a_of_type_Boqr.b(paramboqu);
        return;
        bool1 = false;
        break;
        c(paramboqu);
      }
    }
    label426:
    this.jdField_a_of_type_Boqr.a(paramboqu);
  }
  
  private void c(boqu paramboqu)
  {
    if (paramboqu == null) {}
    while ((paramboqu.f) || (TextUtils.isEmpty(paramboqu.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boqr == null)) {
      return;
    }
    d(paramboqu);
  }
  
  private void d(boqu paramboqu)
  {
    this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_Boqr.a(), paramboqu, this);
  }
  
  public void a(boqu paramboqu)
  {
    b(paramboqu, a(paramboqu));
  }
  
  public void a(boqu paramboqu, int paramInt)
  {
    paramInt = a(paramboqu);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
  
  public void a(boqu paramboqu, boolean paramBoolean)
  {
    if (paramboqu == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(paramboqu);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, paramboqu, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (boqr.a() != null) {
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
        a(((boqq)paramVarArgs[0]).a);
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
  
  public void a(List<boqu> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(boqu.jdField_a_of_type_Boqu);
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
    boqu localboqu = (boqu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localboqu == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      if ((paramViewHolder instanceof boon))
      {
        localObject = (boon)paramViewHolder;
        if (localboqu.equals(boqr.a())) {
          ((boon)localObject).a();
        } else {
          ((boon)localObject).b();
        }
      }
      else if ((paramViewHolder instanceof booo))
      {
        localObject = (booo)paramViewHolder;
        if ((localboqu.equals(boqr.a())) && (localboqu.e))
        {
          ((booo)localObject).a(2, localboqu);
        }
        else
        {
          localboqu.jdField_a_of_type_Boolean = false;
          ((booo)localObject).a(1, localboqu);
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
    boqu localboqu = (boqu)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    b(localboqu);
    if (localboqu.b) {
      localboqu.c = true;
    }
    for (;;)
    {
      b(localboqu, i);
      break;
      localboqu.b = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558503, paramViewGroup, false);
      paramViewGroup = new boon(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558502, paramViewGroup, false);
      paramViewGroup = new booo(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booa
 * JD-Core Version:    0.7.0.1
 */