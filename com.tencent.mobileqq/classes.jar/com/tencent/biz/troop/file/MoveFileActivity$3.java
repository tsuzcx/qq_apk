package com.tencent.biz.troop.file;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class MoveFileActivity$3
  extends TroopFileGetFileListObserver
{
  MoveFileActivity$3(MoveFileActivity paramMoveFileActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List<TroopFileInfo> paramList, Bundle paramBundle)
  {
    this.a.a(true);
    if (paramBoolean1)
    {
      if (paramList == null) {
        return;
      }
      MoveFileActivity.b(this.a, paramInt3);
      MoveFileActivity.a(this.a, paramBoolean2);
      paramBoolean1 = paramBundle.getBoolean("isFirstPage");
      paramByteStringMicro = paramList.iterator();
      while (paramByteStringMicro.hasNext())
      {
        paramBundle = (TroopFileInfo)paramByteStringMicro.next();
        if (MoveFileActivity.h(this.a).f.get(paramBundle.c) == null)
        {
          paramBundle.b = UUID.randomUUID();
          MoveFileActivity.h(this.a).f.put(paramBundle.c, paramBundle);
        }
      }
      if (paramBoolean1)
      {
        MoveFileActivity.b(this.a).clear();
        if (!MoveFileActivity.g(this.a).equals("/"))
        {
          paramByteStringMicro = new TroopFileInfo();
          paramByteStringMicro.d = HardCodeUtil.a(2131904778);
          paramByteStringMicro.c = "/";
          paramByteStringMicro.B = true;
          paramByteStringMicro.s = -1;
          MoveFileActivity.b(this.a).add(paramByteStringMicro);
        }
      }
      MoveFileActivity.c(this.a, paramInt1);
      if (!MoveFileActivity.g(this.a).equals("/"))
      {
        paramInt1 = paramList.size() - 1;
        while (paramInt1 >= 0)
        {
          if (((TroopFileInfo)paramList.get(paramInt1)).c.equals(MoveFileActivity.g(this.a)))
          {
            if (MoveFileActivity.d(this.a) != -1) {
              break;
            }
            paramByteStringMicro = this.a;
            MoveFileActivity.d(paramByteStringMicro, MoveFileActivity.b(paramByteStringMicro).size() + paramInt1 - 1);
            MoveFileActivity.i(this.a).setEnabled(true);
            MoveFileActivity.i(this.a).setBackgroundResource(2130839481);
            MoveFileActivity.i(this.a).setTextAppearance(this.a.getActivity(), 2131952356);
            break;
          }
          paramInt1 -= 1;
        }
        MoveFileActivity.b(this.a).addAll(MoveFileActivity.b(this.a).size() - 1, paramList);
      }
      else
      {
        MoveFileActivity.b(this.a).addAll(paramList);
      }
      MoveFileActivity.j(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.3
 * JD-Core Version:    0.7.0.1
 */