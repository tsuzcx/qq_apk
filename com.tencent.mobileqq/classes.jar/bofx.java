import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectGroupItem;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bofx
  implements EIPCResultCallback
{
  bofx(bofw parambofw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    bnzb.a(bofw.a(this.a), "ipc result.");
    paramEIPCResult = paramEIPCResult.data.getString("effect_group_json_path");
    Object localObject1;
    ArrayList localArrayList;
    label239:
    Object localObject2;
    try
    {
      paramEIPCResult = (AEEditorEffectGroupListBean)bobw.a(paramEIPCResult);
      if ((paramEIPCResult != null) && (paramEIPCResult.effectGroups != null))
      {
        localObject1 = paramEIPCResult;
        if (paramEIPCResult.effectGroups.size() >= 1) {}
      }
      else
      {
        bnzb.b(bofw.c(this.a), "use local effect data.");
        localObject1 = (AEEditorEffectGroupListBean)GsonUtils.json2Obj(bofw.a(this.a, "camera/ae_camera_editor_display_effects.json"), new bofy(this).getType());
      }
      if ((localObject1 == null) || (((AEEditorEffectGroupListBean)localObject1).effectGroups == null) || (((AEEditorEffectGroupListBean)localObject1).effectGroups.size() <= 0))
      {
        bnzb.d(bofw.d(this.a), "effect list is empty.");
        return;
      }
    }
    catch (Exception paramEIPCResult)
    {
      for (;;)
      {
        bnzb.d(bofw.b(this.a), "parse online config error e: " + paramEIPCResult.toString());
        paramEIPCResult = null;
      }
      localArrayList = new ArrayList();
      paramEIPCResult = ((AEEditorEffectGroupListBean)localObject1).effectGroups.iterator();
      while (paramEIPCResult.hasNext())
      {
        localObject1 = (AEEditorEffectGroupListBean.AEEditorEffectGroupItem)paramEIPCResult.next();
        if ((localObject1 != null) && (((AEEditorEffectGroupListBean.AEEditorEffectGroupItem)localObject1).effects != null) && (((AEEditorEffectGroupListBean.AEEditorEffectGroupItem)localObject1).effects.size() > 0))
        {
          localObject1 = ((AEEditorEffectGroupListBean.AEEditorEffectGroupItem)localObject1).effects.iterator();
          AEEditorFilterBean localAEEditorFilterBean;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AEEditorEffectGroupListBean.AEEditorEffectItem)((Iterator)localObject1).next();
            localAEEditorFilterBean = new AEEditorFilterBean();
            localAEEditorFilterBean.setEffectId(((AEEditorEffectGroupListBean.AEEditorEffectItem)localObject2).getEffectID());
            localAEEditorFilterBean.setName(((AEEditorEffectGroupListBean.AEEditorEffectItem)localObject2).getEffectName());
            localAEEditorFilterBean.setPicUrl(((AEEditorEffectGroupListBean.AEEditorEffectItem)localObject2).getThumbURL());
            localAEEditorFilterBean.setEditorEffectItem((AEEditorEffectGroupListBean.AEEditorEffectItem)localObject2);
            if (!"network".equals(((AEEditorEffectGroupListBean.AEEditorEffectItem)localObject2).getEffectType())) {
              break label338;
            }
          }
          label338:
          for (localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.NETWORK;; localAEEditorFilterBean.type = AEEditorFilterBean.FilterID.CLIENT)
          {
            localArrayList.add(localAEEditorFilterBean);
            break label239;
            break;
          }
        }
      }
      localObject1 = bofw.e(this.a);
      localObject2 = new StringBuilder().append("setupDisplayFilterList---filters size = ");
      if (!localArrayList.isEmpty()) {}
    }
    for (paramEIPCResult = "null";; paramEIPCResult = Integer.valueOf(localArrayList.size()))
    {
      bnzb.b((String)localObject1, paramEIPCResult);
      this.a.a().postValue(localArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofx
 * JD-Core Version:    0.7.0.1
 */