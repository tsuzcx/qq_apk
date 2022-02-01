package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class TroopCardGroup
  extends BaseTroopCardView
{
  protected searchtab.Card d;
  protected List<searchtab.Item1> e;
  
  private void a(searchtab.Item1 paramItem1)
  {
    if (paramItem1 == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramItem1.str_transfer_url.get()))
    {
      String str = paramItem1.str_transfer_url.get();
      Object localObject;
      if (this.d.title_bar.str_desc.get().contains(HardCodeUtil.a(2131912528)))
      {
        paramItem1 = new StringBuilder();
        paramItem1.append(str);
        paramItem1.append("&jump_from_group_search=");
        paramItem1.append(String.valueOf(20));
        localObject = paramItem1.toString();
      }
      else
      {
        localObject = str;
        if (this.d.title_bar.str_desc.get().contains(HardCodeUtil.a(2131912527)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("&jump_from_group_search=");
          ((StringBuilder)localObject).append(String.valueOf(21));
          str = ((StringBuilder)localObject).toString();
          if (paramItem1.bytes_algorithm.has()) {
            localObject = paramItem1.bytes_algorithm.get().toStringUtf8();
          } else {
            localObject = "";
          }
          TroopReportor.a("Grp_recom", "search", "recom_clk", 1, 0, new String[] { String.valueOf(paramItem1.uint64_group_code.get()), localObject });
          localObject = str;
        }
      }
      a((String)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCardGroup", 2, "goto groupInfoCard scheme is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup
 * JD-Core Version:    0.7.0.1
 */