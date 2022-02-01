package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class TroopCardGroup
  extends BaseTroopCardView
{
  protected List<searchtab.Item1> a;
  protected searchtab.Card a;
  
  private void a(searchtab.Item1 paramItem1)
  {
    if (paramItem1 == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramItem1.str_transfer_url.get()))
      {
        String str2 = paramItem1.str_transfer_url.get();
        if (this.a.title_bar.str_desc.get().contains(HardCodeUtil.a(2131715115))) {
          str1 = str2 + "&jump_from_group_search=" + String.valueOf(20);
        }
        do
        {
          a(str1);
          return;
          str1 = str2;
        } while (!this.a.title_bar.str_desc.get().contains(HardCodeUtil.a(2131715114)));
        str2 = str2 + "&jump_from_group_search=" + String.valueOf(21);
        if (paramItem1.bytes_algorithm.has()) {}
        for (String str1 = paramItem1.bytes_algorithm.get().toStringUtf8();; str1 = "")
        {
          TroopReportor.a("Grp_recom", "search", "recom_clk", 1, 0, new String[] { String.valueOf(paramItem1.uint64_group_code.get()), str1 });
          str1 = str2;
          break;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopCardGroup", 2, "goto groupInfoCard scheme is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup
 * JD-Core Version:    0.7.0.1
 */