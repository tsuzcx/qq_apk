package com.tencent.mobileqq.activity.emogroupstore;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;

class EmoticonGroupStoreFragment$11
  implements Runnable
{
  EmoticonGroupStoreFragment$11(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    EmoticonGroupStoreFragment.d(this.this$0).a(EmoticonGroupStoreFragment.b(this.this$0));
    EmoticonGroupStoreFragment.d(this.this$0).notifyDataSetChanged();
    TextView localTextView = EmoticonGroupStoreFragment.u(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131902098));
    localStringBuilder.append(EmoticonGroupStoreFragment.k(this.this$0).size());
    localStringBuilder.append(HardCodeUtil.a(2131902086));
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.11
 * JD-Core Version:    0.7.0.1
 */