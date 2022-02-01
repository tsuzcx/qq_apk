package com.android.dx;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Label
{
  Label alternateSuccessor;
  List<Label> catchLabels = Collections.emptyList();
  Code code;
  int id = -1;
  final List<Insn> instructions = new ArrayList();
  boolean marked = false;
  Label primarySuccessor;
  
  void compact()
  {
    int i = 0;
    while (i < this.catchLabels.size())
    {
      while (((Label)this.catchLabels.get(i)).isEmpty()) {
        this.catchLabels.set(i, ((Label)this.catchLabels.get(i)).primarySuccessor);
      }
      i += 1;
    }
    while ((this.primarySuccessor != null) && (this.primarySuccessor.isEmpty())) {
      this.primarySuccessor = this.primarySuccessor.primarySuccessor;
    }
    while ((this.alternateSuccessor != null) && (this.alternateSuccessor.isEmpty())) {
      this.alternateSuccessor = this.alternateSuccessor.primarySuccessor;
    }
  }
  
  boolean isEmpty()
  {
    return this.instructions.isEmpty();
  }
  
  BasicBlock toBasicBlock()
  {
    InsnList localInsnList = new InsnList(this.instructions.size());
    int i = 0;
    while (i < this.instructions.size())
    {
      localInsnList.set(i, (Insn)this.instructions.get(i));
      i += 1;
    }
    localInsnList.setImmutable();
    IntList localIntList = new IntList();
    Iterator localIterator = this.catchLabels.iterator();
    while (localIterator.hasNext()) {
      localIntList.add(((Label)localIterator.next()).id);
    }
    if (this.primarySuccessor != null)
    {
      i = this.primarySuccessor.id;
      localIntList.add(i);
    }
    for (;;)
    {
      if (this.alternateSuccessor != null) {
        localIntList.add(this.alternateSuccessor.id);
      }
      localIntList.setImmutable();
      return new BasicBlock(this.id, localInsnList, localIntList, i);
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.Label
 * JD-Core Version:    0.7.0.1
 */