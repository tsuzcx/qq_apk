package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Prototype;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public final class ProtoIdsSection
  extends UniformItemSection
{
  private final TreeMap<Prototype, ProtoIdItem> protoIds = new TreeMap();
  
  public ProtoIdsSection(DexFile paramDexFile)
  {
    super("proto_ids", paramDexFile, 4);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    throw new UnsupportedOperationException("unsupported");
  }
  
  public int indexOf(Prototype paramPrototype)
  {
    if (paramPrototype == null) {
      throw new NullPointerException("prototype == null");
    }
    throwIfNotPrepared();
    paramPrototype = (ProtoIdItem)this.protoIds.get(paramPrototype);
    if (paramPrototype == null) {
      throw new IllegalArgumentException("not found");
    }
    return paramPrototype.getIndex();
  }
  
  public ProtoIdItem intern(Prototype paramPrototype)
  {
    if (paramPrototype == null) {
      try
      {
        throw new NullPointerException("prototype == null");
      }
      finally {}
    }
    throwIfPrepared();
    ProtoIdItem localProtoIdItem2 = (ProtoIdItem)this.protoIds.get(paramPrototype);
    ProtoIdItem localProtoIdItem1 = localProtoIdItem2;
    if (localProtoIdItem2 == null)
    {
      localProtoIdItem1 = new ProtoIdItem(paramPrototype);
      this.protoIds.put(paramPrototype, localProtoIdItem1);
    }
    return localProtoIdItem1;
  }
  
  public Collection<? extends Item> items()
  {
    return this.protoIds.values();
  }
  
  protected void orderItems()
  {
    Iterator localIterator = items().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ((ProtoIdItem)localIterator.next()).setIndex(i);
      i += 1;
    }
  }
  
  public void writeHeaderPart(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    int j = this.protoIds.size();
    if (j == 0) {}
    for (int i = 0; j > 65536; i = getFileOffset()) {
      throw new UnsupportedOperationException("too many proto ids");
    }
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(4, "proto_ids_size:  " + Hex.u4(j));
      paramAnnotatedOutput.annotate(4, "proto_ids_off:   " + Hex.u4(i));
    }
    paramAnnotatedOutput.writeInt(j);
    paramAnnotatedOutput.writeInt(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.ProtoIdsSection
 * JD-Core Version:    0.7.0.1
 */