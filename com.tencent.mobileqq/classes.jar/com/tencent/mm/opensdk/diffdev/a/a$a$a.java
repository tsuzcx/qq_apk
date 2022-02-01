package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;

class a$a$a
  implements Runnable
{
  a$a$a(a.a parama) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(a.a(this.a.a));
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onQrcodeScanned();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */